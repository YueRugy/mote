package com.yue.controller;

import com.yue.entity.User;
import com.yue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/2/7
 */
@RestController
@RequestMapping("seller")
public class SellerController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 商家注册
     */
    @RequestMapping(value = "register", produces = "application/json", method = RequestMethod.POST)
    public Object register(User user) {
        try {
            userService.registerSeller(user);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

}
