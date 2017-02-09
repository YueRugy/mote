package com.yue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/2/8
 */
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    @GeneratedValue
    @Column(length = 11, updatable = false)
    private Integer id;
    @Column(length = 50)
    private String title;
    private String url;
    @Column(precision = 10)
    private BigDecimal price;
    @Column(precision = 10, name = "shot_fee")
    private BigDecimal shotFee;
    @Column(length = 100, name = "img_url")
    private String imgUrl;
    @Column(precision = 10, name = "self_buy_off")
    private BigDecimal selfBuyOff;
    @Column(length = 100, name = "shot_desc")
    private String shotDesc;
    @Column(length = 1)
    private Integer gender;
    @Column(length = 20)
    private String shape;
    private String shapeCn;
    @Column(length = 5, name = "height_min")
    private Integer heightMin;
    @Column(length = 5, name = "height_max")
    private Integer heightMax;
    @Column(length = 5, name = "age_min")
    private Integer ageMin;
    @Column(length = 5, name = "age_max")
    private Integer ageMax;
    @Column(name = "modeler_level", length = 4)
    private Integer modelerLevel;
    @Column(name = "self_buy_rate", length = 4)
    private Integer selfBuyRate;
    @Column(length = 4)
    private Integer number;
    //private Integer shotAreaId = 0;

    private Integer status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_time")
    private Date finishTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pay_time")
    private Date payTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "approve_time")
    private Date approveTime;
    @Column(precision = 10)
    private BigDecimal totalFee;
    private String nickname;
    @Column(length = 10000, name = "old_url")
    private String oldUrl;
    @Column(name = "accept_status")
    private Integer acceptStatus = 1;
    @Column(name = "accept_number")
    private Integer acceptNumber = 0;
    @Column(name = "follow_num")
    private Integer followNum = 0;
    @Column(name = "send_type")
    private Integer sendType = 2;
    @Column(length = 1, name = "item_type")
    private Integer itemType = 1;
    @Column(length = 1, name = "free_mail")
    private Integer freeMail = 1;
    @Column(length = 1, name = "finish_status")
    private Integer finishStatus;
    @Column(name = "finish_num", length = 4)
    private Integer finishNumber;
    /*Integer moteTaskId;
    String content;
    Boolean isDirect = false;// 是否定向
    Date databaseTime; // 数据库系统时间
    Date futurePublishTime; // 预发布时间
    Boolean isTimerTask = false; // 是否为倒计时任务 false不是
    Boolean isCustomTask = false; // 是否为自定义任务 false不是
    long diffTime; // 倒计时时间,正数倒计时，负数，正常接单
    Integer isVip = 0;
    String h5Url;
    String moteIds;*/
    @Column(name = "un_accept_days")
    private Integer unAcceptDays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getShotFee() {
        return shotFee;
    }

    public void setShotFee(BigDecimal shotFee) {
        this.shotFee = shotFee;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getSelfBuyOff() {
        return selfBuyOff;
    }

    public void setSelfBuyOff(BigDecimal selfBuyOff) {
        this.selfBuyOff = selfBuyOff;
    }

    public String getShotDesc() {
        return shotDesc;
    }

    public void setShotDesc(String shotDesc) {
        this.shotDesc = shotDesc;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getShapeCn() {
        return shapeCn;
    }

    public void setShapeCn(String shapeCn) {
        this.shapeCn = shapeCn;
    }

    public Integer getHeightMin() {
        return heightMin;
    }

    public void setHeightMin(Integer heightMin) {
        this.heightMin = heightMin;
    }

    public Integer getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(Integer heightMax) {
        this.heightMax = heightMax;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public Integer getModelerLevel() {
        return modelerLevel;
    }

    public void setModelerLevel(Integer modelerLevel) {
        this.modelerLevel = modelerLevel;
    }

    public Integer getSelfBuyRate() {
        return selfBuyRate;
    }

    public void setSelfBuyRate(Integer selfBuyRate) {
        this.selfBuyRate = selfBuyRate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOldUrl() {
        return oldUrl;
    }

    public void setOldUrl(String oldUrl) {
        this.oldUrl = oldUrl;
    }

    public Integer getAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(Integer acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public Integer getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(Integer acceptNumber) {
        this.acceptNumber = acceptNumber;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getFreeMail() {
        return freeMail;
    }

    public void setFreeMail(Integer freeMail) {
        this.freeMail = freeMail;
    }

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }

    public Integer getFinishNumber() {
        return finishNumber;
    }

    public void setFinishNumber(Integer finishNumber) {
        this.finishNumber = finishNumber;
    }

    public Integer getUnAcceptDays() {
        return unAcceptDays;
    }

    public void setUnAcceptDays(Integer unAcceptDays) {
        this.unAcceptDays = unAcceptDays;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
