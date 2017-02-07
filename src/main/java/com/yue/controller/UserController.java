package com.yue.controller;

import com.yue.entity.User;
import com.yue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/2/7
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 模特注册
     */
    @RequestMapping(value = "registerMote", produces = "application/json", method = RequestMethod.POST)
    public Object registerMote(User user) {
        try {
            userService.register(user);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /**
     * 模特注册
     */
    @RequestMapping(value = "registerSeller", produces = "application/json", method = RequestMethod.POST)
    public Object registerSeller(User user) {
        try {
            userService.registerSeller(user);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /**
     * 用户个人信息
     */
    @RequestMapping(path = "{id:\\d+}", produces = "application/json", method = RequestMethod.GET)
    public Object getMoteInfo(@PathVariable Integer id) {
        try {
            return toJson(userService.getUserInfo(id));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    /***
     * 用户登录
     */
    @RequestMapping(value = "login", produces = "application/json", method = RequestMethod.POST)
    public Object login(User user) {
        try {
            return toJson(userService.login(user));
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }


}
