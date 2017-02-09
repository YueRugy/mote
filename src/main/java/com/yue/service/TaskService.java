package com.yue.service;

import com.yue.dao.TaskDao;
import com.yue.dao.UserDao;
import com.yue.entity.Task;
import com.yue.entity.User;
import com.yue.enums.FeeChangeType;
import com.yue.enums.UserType;
import com.yue.exception.BusinessException;
import com.yue.exception.ValidateException;
import com.yue.validator.Validator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/2/8
 */
@Service
@Transactional
public class TaskService {
    @Autowired
    TaskDao taskDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ServiceChargeService serviceChargeService;
    @Autowired
    FeeChangeFlowService feeChangeFlowService;

    /**
     * 商家发布任务
     */
    public void publish(Task task, Integer userId, String password) {
        User user = userDao.findByIdAndPassword(userId, password);
        if (user == null || user.getType() != UserType.seller.getValue()) {
            throw new BusinessException("没有权限");
        }
        validate(task);
        //总费用
        BigDecimal serviceFee = serviceChargeService.getServiceFeeByPrice(task.getPrice());
        BigDecimal totalFee = new BigDecimal((task.getPrice().doubleValue() + task.getShotFee().doubleValue() + serviceFee.doubleValue()) * task.getNumber());
        task.setTotalFee(totalFee);
        //初始化其他信息
        task.setAcceptNumber(0);
        task.setAcceptStatus(1);
        task.setFollowNum(0);
        task.setSendType(2);
        task.setItemType(1);
        task.setFreeMail(1);
        task.setFinishNumber(0);
        task.setFinishStatus(0);
        task.setCreateTime(new Date(System.currentTimeMillis()));
        task.setUser(user);
        task.setStatus(2);
        task = taskDao.save(task);
        //扣除金额
        feeChangeFlowService.freezeFee(userId, totalFee, "hello", task.getId(), null, FeeChangeType.task.getValue());

    }


    /**
     * 获取任务详细信息
     */
    public Task getDetailByTaskId(Integer taskId) {
        return taskDao.getOne(taskId);
    }

    /**
     * 获取商家的任务
     */
    public Page<Task> getTaskList(Integer type, Integer id, Pageable pageable) {
        if (type != null) {
            return taskDao.findAll((root, query, cb) -> {
                Predicate condition = null;
                if (type == 1) {
                    condition = cb.equal(root.get("status"), 0);
                } else if (type == 2) {
                    condition = cb.and(cb.equal(root.get("status"), 2), cb.equal(root.get("finishStatus"), 0));
                } else if (type == 3) {
                    condition = cb.equal(root.get("finishStatus"), 1);
                } else if (type == 4) {
                    condition = cb.equal(root.get("status"), 1);
                }
                query.where(condition);
                return null;
            }, pageable);

        } else {
            return taskDao.findAllByUserId(id, pageable);
        }

    }

    public List<Task> getAll(final Task task) {
        return taskDao.findAll((root, query, cb) -> {
            /*Predicate titleEqual = cb.equal(root.<String>get("title"), task.getTitle());
            Predicate genderEqual = cb.equal(root.<Integer>get("gender"), task.getGender());
            query.where(titleEqual).where(genderEqual);*/
            Predicate condition = cb.or(cb.equal(root.get("title"), task.getTitle()), cb.equal(root.get("gender"), task.getGender()));
            query.where(condition);
            return null;
        });
    }


    /**
     * 校验
     */
    private void validate(Task task) {
        Validator.validateBlank(task.getTitle(), "标题不能为空.");
        Validator.validateBlank(task.getUrl(), "商品链接不能为空.");
        Validator.validateBlank(task.getPrice(), "商品价格不能为空.");
        Validator.validateBlank(task.getShotFee(), "拍摄佣金不能为空.");
        Validator.validateBlank(task.getImgUrl(), "商品图片不能为空.");
        Validator.validateBlank(task.getNumber(), "单量不能为空.");
        Validator.validateBlank(task.getItemType(), "商品类型不能为空.");
        Validator.validateBlank(task.getSelfBuyOff(), "自购率(折)不能为空.");
        if (task.getSelfBuyOff().doubleValue() < 0 || task.getSelfBuyOff().doubleValue() > 10) {
            throw new ValidateException("自购率(折)只能在0到10之间.");
        }

        Validator.validateBlank(task.getShotDesc(), "发布要求不能为空.");
        Validator.validateBlank(task.getFreeMail(), "包邮不能为空.");
        if (StringUtils.equals(String.valueOf(task.getSendType()), "2")) {
            Validator.validateBlank(task.getHeightMin(), "身高区间不能为空.");
            Validator.validateBlank(task.getAgeMin(), "年龄区间不能为空.");
            Validator.validateBlank(task.getShape(), "体型不能为空.");

        }
    }


    /**
     * 模特搜索任务
     */
    public Page<Task> search(String keyword, BigDecimal fee, Pageable pageable) {
        return taskDao.findAll((root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (keyword != null) {
                cb.like(root.get("title"), keyword);
                list.add(cb.like(root.get("title"), "%" + keyword + "%"));
            }
            if (fee != null) {
                list.add(cb.ge(root.get("totalFee"), fee));
            }
            query.where(list.toArray(new Predicate[]{}));

            return null;
        }, pageable);
    }
}
