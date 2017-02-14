package com.yue.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/8
 */
@Table(name = "service_charge")
@Entity
public class ServiceCharge {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(precision = 20, scale = 5)
    private BigDecimal fee;
    @Column(precision = 20, scale = 5, name = "min_price")
    private BigDecimal minPrice;
    @Column(precision = 20, scale = 5, name = "max_price")
    private BigDecimal maxPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
