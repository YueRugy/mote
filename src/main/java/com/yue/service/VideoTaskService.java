package com.yue.service;

import com.yue.dao.UserDao;
import com.yue.dao.VideoTaskDao;
import com.yue.entity.User;
import com.yue.entity.UserInfo;
import com.yue.entity.VideoTask;
import com.yue.enums.FeeChangeType;
import com.yue.enums.UserType;
import com.yue.enums.VideoTaskApproveStatus;
import com.yue.enums.VideoTaskStatus;
import com.yue.exception.BusinessException;
import com.yue.util.LockUtil;
import com.yue.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/2/13
 */
@Service
@Transactional
public class VideoTaskService {
    @Autowired
    VideoTaskDao videoTaskDao;
    @Autowired
    UserDao userDao;
    @Autowired
    FeeChangeFlowService feeChangeFlowService;

    /**
     * 商家发布任务
     */
    public void publish(Integer userId, VideoTask videoTask) {
        // 校验
        Validator.validateBlank(videoTask.getTitle(), "标题不能为空");
        Validator.validateBlank(videoTask.getContent(), "内容/要求不能为空");
        Validator.validateBlank(videoTask.getSexLimit(), "性别限制不能为空");
        Validator.validateBlank(videoTask.getRequireNum(), "需求人数不能为空");
        Validator.validateBlank(videoTask.getVideoLimitTime(), "视频时长不能为空");
        Validator.validateBlank(videoTask.getIsReturn(), "是否需要返回不能为空");
        Validator.validateBlank(videoTask.getCommission(), "佣金不能为空");
        Validator.validateBlank(videoTask.getMargin(), "保证金不能为空");

        User seller = userDao.findOne(userId);
        if (seller == null || seller.getType() != UserType.seller.getValue()) {
            throw new BusinessException("不能发布任务");
        }

        UserInfo userInfo = seller.getUserInfo();
        if (userInfo == null) {
            throw new BusinessException("不能发布任务");
        }

        if (videoTask.getCommission().doubleValue() < 0) {
            throw new BusinessException("佣金不能小于0");
        }
        if (videoTask.getMargin().doubleValue() < 0) {
            throw new BusinessException("保证金不能小于0");
        }

        if (userInfo.getRemindFee().compareTo(videoTask.getCommission().multiply(new BigDecimal(videoTask.getRequireNum()))) < 0) {
            throw new BusinessException("余额不足");
        }

        videoTask.setUser(seller);
        videoTask.setCreateTime(new Date(System.currentTimeMillis()));
        videoTask.setAuditStatus(VideoTaskApproveStatus.waitApprove.getValue());
        videoTask.setStatus(VideoTaskStatus.publish.getValue());

        videoTask = videoTaskDao.save(videoTask);
        LockUtil.set(String.valueOf(videoTask.getId()));
        //记录流水
        feeChangeFlowService.freezeFee(seller.getId(), videoTask.getCommission().multiply(new BigDecimal(videoTask.getRequireNum())),
                "冻结金额,发布视频任务[" + videoTask.getTitle() + "],任务号[" + videoTask.getId() + "]", videoTask.getId(), null, FeeChangeType.videoTask.getValue());

    }

    /**
     * 商家查看任务
     */
    public Page<VideoTask> sellerSearch(Integer userId, Pageable pageable) {
        User seller = userDao.findOne(userId);
        if (seller == null || seller.getType() != UserType.seller.getValue()) {
            throw new BusinessException("商家不存在");
        }

        return videoTaskDao.findAll(pageable);

        // return null;
    }
}
