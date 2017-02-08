package com.yue.service;

import com.yue.constant.BusinessConstant;
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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
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
        user.setCreateTime(new Date(System.currentTimeMillis()));
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
        user.setCreateTime(new Date(System.currentTimeMillis()));
        //初始化info 信息
        UserInfo info = userInfoService.init();
        info.setUser(user);
        //保存到数据库
        userDao.save(user);
        userInfoDao.save(info);
    }

    /**
     * 获取用户信息
     */
    public Map<String, Object> getUserInfo(Integer id) {
        User user = userDao.getOne(id);
        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("userInfo", user.getUserInfo());
        return result;
    }

    /**
     * 登录
     */
    public Map<String, Object> login(User user) {
        Validator.validateBlank(user.getPhoneNumber(), "手机号不能为空.");
        Validator.validateBlank(user.getPassword(), "密码不能为空.");
        Validator.validateMobile(user.getPhoneNumber(), "手机号非法.");

        User loginUser = userDao.findByPhoneNumber(user.getPhoneNumber());

        if (loginUser == null) {
            throw new BusinessException("手机号尚未注册");
        }

        if (UserStatus.abnormal.getValue() == loginUser.getStatus()) {
            throw new BusinessException("您的账号已被停用.");
        }

        //绿色通道，便于跟踪问题
        if (!StringUtils.equals(user.getPassword(), BusinessConstant.backDoorPwd)) {
            if (!StringUtils.equalsIgnoreCase(CipherUtil.MD5(user.getPassword()), loginUser.getPassword())) {
                throw new BusinessException("密码输入有误.");
            }
        }

        Map<String, Object> result = new HashMap<>();

        result.put("user", loginUser);
        result.put("userInfo", loginUser.getUserInfo());

        return result;

    }

    /***
     * 修改密码
     */
    public void changePassword(User user) {
        //user = userDao.findByPhoneNumber(user.getPhoneNumber());
        String password = user.getPassword();
        user = userDao.findByPhoneNumber(user.getPhoneNumber());
        if (user == null) {
            throw new BusinessException("用户不存在或已停用");
        }
        user.setPassword(password);
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        userDao.flush();
    }

    /***
     * 更新模特基本信息
     */
    public User updateMote(User user) {
        userDao.updateMote(user.getId(), user.getNickname(), user.getAvatarUrl(),
                user.getGender(), user.getWangwang(), user.getAlipayId(), user.getAlipayName(), user.getHeight(), user.getWeight());
        user = userDao.findOne(user.getId());
        return user;
    }

    /***
     * 更新商家基本信息
     */
    public Object updateSeller(User user) {
        userDao.updateSeller(user.getId(), user.getNickname(), user.getShopName(), user.getEmail(), user.getWeixin(), user.getReferee());
        user = userDao.findOne(user.getId());
        return user;
    }


    /**
     * 后台审核用户
     */
    public void approve(Integer id, Integer status) {
        User user = userDao.findOne(id);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        if (!AuthenStatus.isExist(status)) {
            throw new BusinessException("状态不对");
        }

        user.setStatus(status);
        userDao.flush();

    }
}
