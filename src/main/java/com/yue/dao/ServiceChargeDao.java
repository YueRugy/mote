package com.yue.dao;

import com.yue.entity.ServiceCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/8
 */
@Repository
public interface ServiceChargeDao extends JpaRepository<ServiceCharge, Integer> {
    ServiceCharge findByMinPriceLessThan(BigDecimal price);

    @Query("select fee from ServiceCharge where maxPrice>:price and  minPrice<=:price")
    BigDecimal findServiceFee(@Param("price") BigDecimal price);
}
