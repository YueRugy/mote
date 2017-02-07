package com.yue.service;

import com.yue.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/7
 */
@Service
@Transactional
public class UserInfoService {


    public UserInfo init() {
        UserInfo info = new UserInfo();
        info.setFinishNum(0);
        info.setFollowNum(0);
        info.setFreezeFee(new BigDecimal(0.0));
        info.setRemindFee(new BigDecimal(0.0));
        info.setTotalIncome(new BigDecimal(0.0));
        return info;
    }
}
