package com.yue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by admin on 2017/2/7
 */
@Table(name = "user_info")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserInfo {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;
    @Column(precision = 10, name = "remind_fee")
    private BigDecimal remindFee;
    @Column(precision = 10, name = "freeze_fee")
    private BigDecimal freezeFee;
    @Column(name = "finish_num", length = 11)
    private Integer finishNum;// 完成数
    // private Double selfBuyRate;// 自购率
    @Column(name = "follow_num", length = 11)
    private Integer followNum;// 关注数
    @Column(precision = 10, name = "total_income")
    private BigDecimal totalIncome;// 总收入
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @OneToOne
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRemindFee() {
        return remindFee;
    }

    public void setRemindFee(BigDecimal remindFee) {
        this.remindFee = remindFee;
    }

    public BigDecimal getFreezeFee() {
        return freezeFee;
    }

    public void setFreezeFee(BigDecimal freezeFee) {
        this.freezeFee = freezeFee;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }
}
