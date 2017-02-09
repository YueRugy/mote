package com.yue.service;

import com.yue.dao.FeeChangeFlowDao;
import com.yue.dao.UserDao;
import com.yue.dao.UserInfoDao;
import com.yue.entity.FeeChangeFlow;
import com.yue.entity.UserInfo;
import com.yue.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/9
 */
@Service
@Transactional
class FeeChangeFlowService {
    @Autowired
    FeeChangeFlowDao feeChangeFlowDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserInfoDao userInfoDao;

    void freezeFee(Integer userId, BigDecimal fee, String reason, Integer referId, Integer moteId, Integer type) {

        if (fee.doubleValue() <= 0) {
            throw new BusinessException("冻结金额,小于0");
        }
        UserInfo userInfo = userInfoDao.findOne(userId);
        if (userInfo.getRemindFee().doubleValue() < fee.doubleValue()) {
            throw new BusinessException("冻结金额 预存款不足,userId=" + userId + "fee:[" + fee + "]");
        }
        //记录流水
        FeeChangeFlow flow = new FeeChangeFlow();
        flow.setUserId(userId);
        flow.setBeforeRemindFee(userInfo.getRemindFee());
        flow.setBeforeFreezeFee(userInfo.getRemindFee());
        flow.setRemindChange(new BigDecimal("-" + fee.toString()));
        flow.setFreezeChange(fee);
        flow.setReason(reason);
        flow.setReferId(referId);
        flow.setMoteId(moteId);
        flow.setType(type);
        //更新userInfo
        userInfoService.addPlus(userInfo, fee);
        feeChangeFlowDao.save(flow);

    }
}
