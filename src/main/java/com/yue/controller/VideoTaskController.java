package com.yue.controller;

import com.yue.entity.VideoTask;
import com.yue.service.VideoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/2/13
 */
@RestController
@RequestMapping("videoTask")
public class VideoTaskController extends BaseController {
    @Autowired
    VideoTaskService videoTaskService;

    /***
     * 发布短视频任务
     */
    @RequestMapping(value = "publish", produces = "application/json", method = RequestMethod.POST)
    public Object publish(Integer userId, VideoTask videoTask) {
        try {
            videoTaskService.publish(userId, videoTask);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /**
     * 商家查看任务
     */
    @RequestMapping(value = "sellerSearch", produces = "application/json", method = RequestMethod.POST)
    public Object sellerSearch(Integer userId,
                               @PageableDefault(sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            return toJson(videoTaskService.sellerSearch(userId, pageable));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }


}
