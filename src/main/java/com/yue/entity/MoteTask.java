package com.yue.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/2/13
 */
@Entity
@Table(name = "mote_task")
public class MoteTask {
    @Id
    @GeneratedValue
    @Column(length = 11, nullable = false, updatable = false)
    private Integer id;
    @Column(length = 11, nullable = true, updatable = false)
    private Integer userId;
    @Column(length = 11, nullable = true, updatable = false)
    private Integer taskId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", updatable = false)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
    private String orderNo;
    @Column(precision = 20,scale = 5)
    private BigDecimal selfBuyFee;
    @Column(length = 2)
    private Integer status;
    @Column(name = "finish_status", length = 2)
    private Integer finishStatus;
    @Temporal(TemporalType.DATE)
    @Column(name = "accepted_time")
    private Date acceptedTime;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_no_time")
    private Date orderNoTime;
    @Temporal(TemporalType.DATE)
    @Column(name = "show_pic_time")
    private Date showPicTime;
    @Column(name = "upload_pic_time")
    @Temporal(TemporalType.DATE)
    private Date uploadPicTime;
    @Column(name = "return_item_time")
    @Temporal(TemporalType.DATE)
    private Date returnItemTime;
    @Temporal(TemporalType.DATE)
    @Column(name = "finish_status_time")
    private Date finishStatusTime;
    @Temporal(TemporalType.DATE)
    @Column(name = "self_buy_time")
    private Date selfBuyTime;
    @Column(length = 2, name = "pic_approve_status")
    private Integer picApproveStatus;


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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getSelfBuyFee() {
        return selfBuyFee;
    }

    public void setSelfBuyFee(BigDecimal selfBuyFee) {
        this.selfBuyFee = selfBuyFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }

    public Date getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(Date acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public Date getOrderNoTime() {
        return orderNoTime;
    }

    public void setOrderNoTime(Date orderNoTime) {
        this.orderNoTime = orderNoTime;
    }

    public Date getShowPicTime() {
        return showPicTime;
    }

    public void setShowPicTime(Date showPicTime) {
        this.showPicTime = showPicTime;
    }

    public Date getUploadPicTime() {
        return uploadPicTime;
    }

    public void setUploadPicTime(Date uploadPicTime) {
        this.uploadPicTime = uploadPicTime;
    }

    public Date getReturnItemTime() {
        return returnItemTime;
    }

    public void setReturnItemTime(Date returnItemTime) {
        this.returnItemTime = returnItemTime;
    }

    public Date getFinishStatusTime() {
        return finishStatusTime;
    }

    public void setFinishStatusTime(Date finishStatusTime) {
        this.finishStatusTime = finishStatusTime;
    }

    public Date getSelfBuyTime() {
        return selfBuyTime;
    }

    public void setSelfBuyTime(Date selfBuyTime) {
        this.selfBuyTime = selfBuyTime;
    }

    public Integer getPicApproveStatus() {
        return picApproveStatus;
    }

    public void setPicApproveStatus(Integer picApproveStatus) {
        this.picApproveStatus = picApproveStatus;
    }
}
