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
@RequestMapping("mote")
public class MoteController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 模特注册
     */
    @RequestMapping(value = "register", produces = "application/json", method = RequestMethod.POST)
    public Object register(User user) {
        try {
            userService.register(user);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

    @RequestMapping(path = "{id:\\d+}", produces = "application/json", method = RequestMethod.GET)
    public Object getSellerInfo(@PathVariable Integer id) {
        try {
            userService.getUserInfo(id);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }


}
