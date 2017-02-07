package com.yue.service;

import com.yue.dao.UserDao;
import com.yue.dao.UserInfoDao;
import com.yue.entity.User;
import com.yue.entity.UserInfo;
import com.yue.enums.AuthenStatus;
import com.yue.enums.UserStatus;
import com.yue.enums.UserType;
import com.yue.exception.BusinessException;
import com.yue.util.CipherUtil;
import com.yue.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by admin on 2017/2/7
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserInfoDao userInfoDao;

    /***
     * 模特注册
     */
    public void register(User user) {
        //校验
        Validator.validateMobile(user.getPhoneNumber(), "手机号不正确");
        Validator.validateMinLength(user.getPassword(), 6, "密码长度不够6位");
        if (validator(user.getPhoneNumber())) {
            throw new BusinessException("该手机号已经注册！");
        }
        //密码加密 初始化状态
        user.setPassword(CipherUtil.MD5(user.getPassword()));
        user.setStatus(UserStatus.normal.getValue());
        user.setAttestStatus(AuthenStatus.unAuthen.getValue());
        user.setType(UserType.mote.getValue());
        //初始化info 信息
        UserInfo info = userInfoService.init();
        info.setUser(user);
        //保存到数据库
        userDao.save(user);
        userInfoDao.save(info);
    }

    /***
     * 根据手机号校验用户是否存在
     */
    private boolean validator(String phoneNumber) {
        return userDao.findByPhoneNumber(phoneNumber) != null;
    }

    /***
     * 商家注册
     */
    public void registerSeller(User user) {
        //校验
        Validator.validateMobile(user.getPhoneNumber(), "手机号不正确");
        Validator.validateMinLength(user.getPassword(), 6, "密码长度不够6位");
        if (validator(user.getPhoneNumber())) {
            throw new BusinessException("该手机号已经注册！");
        }
        //密码加密 初始化状态
        user.setPassword(CipherUtil.MD5(user.getPassword()));
        user.setStatus(UserStatus.normal.getValue());
        user.setAttestStatus(AuthenStatus.unAuthen.getValue());
        user.setType(UserType.seller.getValue());
        //初始化info 信息
        UserInfo info = userInfoService.init();
        info.setUser(user);
        //保存到数据库
        userDao.save(user);
        userInfoDao.save(info);
    }

    public Map<String, Object> getUserInfo(Integer id) {
        return null;

    }
}
