package com.yue.service;

import com.yue.dao.UserInfoDao;
import com.yue.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/7
 */
@Service
@Transactional
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;


    UserInfo init() {
        UserInfo info = new UserInfo();
        info.setFinishNum(0);
        info.setFollowNum(0);
        info.setFreezeFee(new BigDecimal(0.0));
        info.setRemindFee(new BigDecimal(0.0));
        info.setTotalIncome(new BigDecimal(0.0));
        return info;
    }

   /* *//**
     * 余额减少冻结金额增加
     *//*
    public void addPlus(Integer userId, BigDecimal fee) {
        UserInfo userInfo = userInfoDao.findByUserId(userId);
        userInfo.setRemindFee(userInfo.getRemindFee().subtract(fee));
        userInfo.setFreezeFee(userInfo.getFreezeFee().add(fee));
        userInfoDao.save(userInfo);
    }*/

    /**
     * 余额减少冻结金额增加
     */
    void addPlus(UserInfo userInfo, BigDecimal fee) {
        userInfo.setRemindFee(userInfo.getRemindFee().subtract(fee));
        userInfo.setFreezeFee(userInfo.getFreezeFee().add(fee));
        userInfoDao.save(userInfo);
    }


}
