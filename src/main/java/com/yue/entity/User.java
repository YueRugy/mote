package com.yue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2017/2/7
 */
@Table
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20, nullable = false, unique = true)
    private String phoneNumber;
    @Column(length = 200, nullable = false)
    @JsonIgnore
    private String password;
    @Column(name = "avatar_url", length = 200)
    private String avatarUrl;
    @Column(length = 100)
    private String nickname;
    @Column(length = 4)
    private Integer gender;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(length = 4)
    private Integer height;
    @Column(length = 4)
    private Integer weight;
    @Column(length = 100)
    private String wangwang;
    @Column(name = "alipay_id", length = 100)
    private String alipayId;
    @Column(name = "alipay_name", length = 100)
    private String alipayName;
    @Column(length = 1, nullable = false)
    private Integer status;
    @Column(length = 1)
    private Integer type;
    @Column(name = "shop_name", length = 100, updatable = false)
    private String shopName;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String weixin;
    @Column(length = 200)
    private String address;
    @Column(length = 50)
    private String referee;
    @Column(length = 50)
    private String ip;// pc端登陆的ip地址
    @Column(length = 2)
    private Integer shape;
    @Column(length = 2)
    private Integer age;
    @Column(name = "real_name", length = 100)
    private String realName; //   真实姓名
    @Column(name = "id_number", length = 20)
    private String idNumber;// 身份证号
    @Column(name = "msg_switch", length = 1)
    private Integer msgSwitch;// 消息开关
    @Column(name = "attest_status", length = 1)
    private Integer attestStatus;// 认证状态
    @Column(name = "attest_pic1", length = 100)
    private String attestPic1;// 认证图片1
    @Column(name = "attest_pic2", length = 100)
    private String attestPic2;// 认证图片2
    @Column(name = "attest_pic3", length = 100)
    private String attestPic3;// 认证图片3
    @Column(name = "return_item_mobile", length = 20)
    private String returnItemMobile;// 收货电话
    @Column(name = "id_card_pic", length = 100)
    private String idCardPic; // 省份证号码图片
    @Column(name = "charge_person_mobile", length = 20)
    private String chargePersonMobile;// 负责人联系手机号
    @Column(name = "charge_person", length = 50)
    private String chargePerson;// 负责人
    @Column(length = 20)
    private String qq; // qq号码
    @Column(name = "return_item_person", length = 50)
    private String returnItemPerson;// 收货人姓名
    @Column(name = "return_item_tel_code", length = 50)
    private String returnItemTelCode;// 固定电话区号
    @Column(name = "return_item_tel_number", length = 50)
    private String returnItemTelNumber;// 固定电话号码
    /*private Integer lastDeviceType;// 最后登陆的设备类型 1：andriod 2：ios
    private String lastDeviceId;// 最后登陆的设备id
    private Integer iosInhouse = 0;// ISO 企业版 0不是，1是
    private Integer iosDeveloperTesting = 0;// 证书类型 1开发 0正式*/
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }*/

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWangwang() {
        return wangwang;
    }

    public void setWangwang(String wangwang) {
        this.wangwang = wangwang;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getShape() {
        return shape;
    }

    public void setShape(Integer shape) {
        this.shape = shape;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getMsgSwitch() {
        return msgSwitch;
    }

    public void setMsgSwitch(Integer msgSwitch) {
        this.msgSwitch = msgSwitch;
    }

    public Integer getAttestStatus() {
        return attestStatus;
    }

    public void setAttestStatus(Integer attestStatus) {
        this.attestStatus = attestStatus;
    }

    public String getAttestPic1() {
        return attestPic1;
    }

    public void setAttestPic1(String attestPic1) {
        this.attestPic1 = attestPic1;
    }

    public String getAttestPic2() {
        return attestPic2;
    }

    public void setAttestPic2(String attestPic2) {
        this.attestPic2 = attestPic2;
    }

    public String getAttestPic3() {
        return attestPic3;
    }

    public void setAttestPic3(String attestPic3) {
        this.attestPic3 = attestPic3;
    }

    public String getReturnItemMobile() {
        return returnItemMobile;
    }

    public void setReturnItemMobile(String returnItemMobile) {
        this.returnItemMobile = returnItemMobile;
    }

    public String getIdCardPic() {
        return idCardPic;
    }

    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic;
    }

    public String getChargePersonMobile() {
        return chargePersonMobile;
    }

    public void setChargePersonMobile(String chargePersonMobile) {
        this.chargePersonMobile = chargePersonMobile;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getReturnItemPerson() {
        return returnItemPerson;
    }

    public void setReturnItemPerson(String returnItemPerson) {
        this.returnItemPerson = returnItemPerson;
    }

    public String getReturnItemTelCode() {
        return returnItemTelCode;
    }

    public void setReturnItemTelCode(String returnItemTelCode) {
        this.returnItemTelCode = returnItemTelCode;
    }

    public String getReturnItemTelNumber() {
        return returnItemTelNumber;
    }

    public void setReturnItemTelNumber(String returnItemTelNumber) {
        this.returnItemTelNumber = returnItemTelNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", height=" + height +
                ", weight=" + weight +
                ", wangwang='" + wangwang + '\'' +
                ", alipayId='" + alipayId + '\'' +
                ", alipayName='" + alipayName + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", shopName='" + shopName + '\'' +
                ", email='" + email + '\'' +
                ", weixin='" + weixin + '\'' +
                ", address='" + address + '\'' +
                ", referee='" + referee + '\'' +
                ", ip='" + ip + '\'' +
                ", shape=" + shape +
                ", age=" + age +
                ", realName='" + realName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", msgSwitch=" + msgSwitch +
                ", attestStatus=" + attestStatus +
                ", attestPic1='" + attestPic1 + '\'' +
                ", attestPic2='" + attestPic2 + '\'' +
                ", attestPic3='" + attestPic3 + '\'' +
                ", returnItemMobile='" + returnItemMobile + '\'' +
                ", idCardPic='" + idCardPic + '\'' +
                ", chargePersonMobile='" + chargePersonMobile + '\'' +
                ", chargePerson='" + chargePerson + '\'' +
                ", qq='" + qq + '\'' +
                ", returnItemPerson='" + returnItemPerson + '\'' +
                ", returnItemTelCode='" + returnItemTelCode + '\'' +
                ", returnItemTelNumber='" + returnItemTelNumber + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", userInfo=" + userInfo +
                '}';
    }
}
