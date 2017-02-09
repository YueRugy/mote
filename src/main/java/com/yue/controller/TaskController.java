package com.yue.controller;

import com.yue.entity.Task;
import com.yue.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/8
 */
@RestController
@RequestMapping("task")
public class TaskController extends BaseController {
    @Autowired
    TaskService taskService;

    /***
     * 商家发布任务
     */
    @RequestMapping(value = "publish", produces = "application/json", method = RequestMethod.POST)
    public Object publish(Task task, Integer userId, String password) {
        try {
            taskService.publish(task, userId, password);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /***
     * 获取任务详细信息 简洁版
     */
    @RequestMapping(path = "{id:\\d+}", produces = "application/json", method = RequestMethod.GET)
    public Object getDetailByTaskId(@PathVariable Integer id) {
        try {
            return toJson(taskService.getDetailByTaskId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /**
     * 查询商家的任务
     */
    @RequestMapping(value = "getTaskList", produces = "application/json", method = RequestMethod.POST)
    public Object getTaskList(Integer id, Integer type, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        try {

            return toJson(taskService.getTaskList(type, id, pageable));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /**
     * 测试专用
     */
    @RequestMapping(value = "test", produces = "application/json", method = RequestMethod.POST)
    public Object test(Task task) {
        try {
            return toJson(taskService.getAll(task));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /***
     * 模特搜索任务
     */
    @RequestMapping(value = "search", produces = "application/json", method = RequestMethod.POST)
    public Object search(String keyword, BigDecimal fee,
                         @PageableDefault(value = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            return toJson(taskService.search(keyword, fee, pageable));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }


}
