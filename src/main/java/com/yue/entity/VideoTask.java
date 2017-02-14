package com.yue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/2/13
 */
@Table(name = "video_task")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VideoTask {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(updatable = false)
    private String title;
    @Column(updatable = false)
    private String content;
    @Column(length = 2, name = "sex_limit", updatable = false)
    private Integer sexLimit;
    @Column(length = 3, name = "require_num", updatable = false)
    private Integer requireNum;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date deadline;
    @Column(name = "videoLimit_time", updatable = false)
    private Integer videoLimitTime;
    @Column(length = 2, name = "is_return", updatable = false)
    private Integer isReturn;
    @Column(precision = 20, scale = 5, updatable = false)
    private BigDecimal commission;
    @Column(precision = 20, scale = 5, updatable = false)
    private BigDecimal margin;
    @Column(length = 2, name = "audit_status")
    private Integer auditStatus;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(length = 2, updatable = false)
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, name = "create_time")
    private Date createTime;
    @Column(updatable = false)
    private String imgUrl;
    @Column(name = "failure_reason")
    private String failureReason;
    @Column(length = 2)
    private Integer status;
    @Column(name = "select_num")
    private Integer selectNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSexLimit() {
        return sexLimit;
    }

    public void setSexLimit(Integer sexLimit) {
        this.sexLimit = sexLimit;
    }

    public Integer getRequireNum() {
        return requireNum;
    }

    public void setRequireNum(Integer requireNum) {
        this.requireNum = requireNum;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getVideoLimitTime() {
        return videoLimitTime;
    }

    public void setVideoLimitTime(Integer videoLimitTime) {
        this.videoLimitTime = videoLimitTime;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
