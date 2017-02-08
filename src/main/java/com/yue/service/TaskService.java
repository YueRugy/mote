package com.yue.service;

import com.yue.dao.TaskDao;
import com.yue.dao.UserDao;
import com.yue.entity.Task;
import com.yue.entity.User;
import com.yue.enums.UserType;
import com.yue.exception.BusinessException;
import com.yue.exception.ValidateException;
import com.yue.validator.Validator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

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

        taskDao.save(task);

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

    public Task getDetailByTaskId(Integer taskId) {
        return taskDao.getOne(taskId);
    }
}
