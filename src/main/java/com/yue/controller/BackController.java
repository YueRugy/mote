package com.yue.controller;

import com.yue.entity.User;
import com.yue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static sun.plugin2.util.PojoUtil.toJson;

/**
 * Created by admin on 2017/2/8
 */
@RestController
@RequestMapping("back")
public class BackController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 后台审核用户
     */
    @RequestMapping(value = "approve", produces = "application/json", method = RequestMethod.POST)
    public Object approve(Integer id, Integer status) {
        try {
            userService.approve(id, status);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return errorJson(e.getMessage());
        }
    }

}
