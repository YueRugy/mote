package com.yue.service;

import com.yue.dao.ServiceChargeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/8
 */
@Service
@Transactional
public class ServiceChargeService {
    @Autowired
    ServiceChargeDao serviceChargeDao;

    BigDecimal getServiceFeeByPrice(BigDecimal price) {
        return serviceChargeDao.findServiceFee(price);
    }
}
