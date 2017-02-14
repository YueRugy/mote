package com.yue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2017/2/14
 */
@Entity
@Table(name = "video_mote_task")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VideoMoteTask {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 2)
    private Integer selected;
    @JoinColumn(name = "task_id")
    @ManyToOne
    private VideoTask videoTask;
    @Column(length = 11, name = "user_id")
    private Integer userId;
    @Column(length = 11, name = "seller_id")
    private Integer sellerId;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(name = "audit_status", length = 2)
    private Integer auditStatus;
    @Column(length = 2)
    private Integer status;
    @Column(name = "img_url")
    private String imgUrl;
    private String reason;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "select_time")
    private Date selectTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public VideoTask getVideoTask() {
        return videoTask;
    }

    public void setVideoTask(VideoTask videoTask) {
        this.videoTask = videoTask;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSelectTime() {
        return selectTime;
    }

    public void setSelectTime(Date selectTime) {
        this.selectTime = selectTime;
    }
}
