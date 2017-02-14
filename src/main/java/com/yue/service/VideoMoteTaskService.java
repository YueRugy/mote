package com.yue.service;

import com.yue.dao.UserDao;
import com.yue.dao.VideoMoteTaskDao;
import com.yue.dao.VideoTaskDao;
import com.yue.entity.User;
import com.yue.entity.UserInfo;
import com.yue.entity.VideoMoteTask;
import com.yue.entity.VideoTask;
import com.yue.enums.FeeChangeType;
import com.yue.enums.UserType;
import com.yue.enums.VideoMoteTaskStatus;
import com.yue.exception.BusinessException;
import com.yue.util.LockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.yue.enums.VideoTaskStatus.*;

/**
 * Created by admin on 2017/2/14
 */
@Service
@Transactional
public class VideoMoteTaskService {
    @Autowired
    VideoMoteTaskDao videoMoteTaskDao;
    @Autowired
    UserDao userDao;
    @Autowired
    VideoTaskDao videoTaskDao;
    @Autowired
    FeeChangeFlowService feeChangeFlowService;

    /***
     * 模特报名
     *
     * @param userId
     * @param taskId
     */
    public void apply(Integer userId, Integer taskId) {
        synchronized (LockUtil.getVideo(String.valueOf(taskId))) {
            User mote = userDao.findOne(userId);
            if (mote == null || mote.getType() != UserType.mote.getValue()) {
                throw new BusinessException("不是模特不能报名");
            }

            VideoTask videoTask = videoTaskDao.findOne(taskId);
            // 判断任务存不存在 是否已经完成或者任务已经取消
            if (videoTask == null || videoTask.getStatus() == cancel.getValue()
                    || videoTask.getStatus() == complete.getValue()) {
                throw new BusinessException("任务存不存在 已经完成或者任务已经取消");
            }

            VideoMoteTask videoMoteTask = videoMoteTaskDao.findByUserIdAndVideoTask(userId, videoTask);
            if (videoMoteTask != null) {
                throw new BusinessException("任务存不存在 已经完成或者任务已经取消");
            }

            UserInfo info = mote.getUserInfo();

            if (info.getRemindFee().compareTo(videoTask.getMargin()) < 0) {
                throw new BusinessException("余额不足");
            }

            videoMoteTask = new VideoMoteTask();
            videoMoteTask.setStatus(VideoMoteTaskStatus.sign.getValue());
            videoMoteTask = new VideoMoteTask();
            videoMoteTask.setVideoTask(videoTask);
            videoMoteTask.setUserId(mote.getId());
            videoMoteTask.setSellerId(videoTask.getUser().getId());
            videoMoteTask.setSelected(0);
            videoMoteTask.setAuditStatus(0);
            videoMoteTask.setStatus(VideoMoteTaskStatus.sign.getValue());

            videoMoteTask = videoMoteTaskDao.save(videoMoteTask);
            //冻结金额
            feeChangeFlowService.freezeFee(userId, videoTask.getMargin(),
                    "冻结金额,参加短视频任务[" + videoTask.getTitle() + "],任务号[" + videoTask.getId() + "]", videoMoteTask.getId(), userId, FeeChangeType.signVideo.getValue());

        }
    }



}
