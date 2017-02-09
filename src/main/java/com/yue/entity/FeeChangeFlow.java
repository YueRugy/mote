package com.yue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/2/9
 */
@Table(name = "fee_change_flow")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FeeChangeFlow {
    @Id
    @GeneratedValue
    @Column(length = 11)
    private Integer id;
    @Column(length = 11, name = "user_id")
    private Integer userId;
    @Column(precision = 10)
    private BigDecimal remindChange;
    @Column(precision = 10)
    private BigDecimal freezeChange;

    private String reason;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(precision = 10)
    private BigDecimal beforeRemindFee;
    @Column(precision = 10)
    private BigDecimal beforeFreezeFee;

    private Integer referId;

    private Integer moteId;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getRemindChange() {
        return remindChange;
    }

    public void setRemindChange(BigDecimal remindChange) {
        this.remindChange = remindChange;
    }

    public BigDecimal getFreezeChange() {
        return freezeChange;
    }

    public void setFreezeChange(BigDecimal freezeChange) {
        this.freezeChange = freezeChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBeforeRemindFee() {
        return beforeRemindFee;
    }

    public void setBeforeRemindFee(BigDecimal beforeRemindFee) {
        this.beforeRemindFee = beforeRemindFee;
    }

    public BigDecimal getBeforeFreezeFee() {
        return beforeFreezeFee;
    }

    public void setBeforeFreezeFee(BigDecimal beforeFreezeFee) {
        this.beforeFreezeFee = beforeFreezeFee;
    }

    public Integer getReferId() {
        return referId;
    }

    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public Integer getMoteId() {
        return moteId;
    }

    public void setMoteId(Integer moteId) {
        this.moteId = moteId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
