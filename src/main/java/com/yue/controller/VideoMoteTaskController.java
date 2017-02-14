package com.yue.controller;

import com.yue.entity.VideoTask;
import com.yue.service.VideoMoteTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/2/14
 */
@RestController
@RequestMapping("videoMote")
public class VideoMoteTaskController extends BaseController {
    @Autowired
    VideoMoteTaskService videoMoteTaskService;

    @RequestMapping(value = "apply", produces = "application/json", method = RequestMethod.POST)
    public Object apply(Integer userId, Integer taskId) {
        try {
            videoMoteTaskService.apply(userId, taskId);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }


}
