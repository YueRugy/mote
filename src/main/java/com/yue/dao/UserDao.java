package com.yue.dao;

import com.yue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/7
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByPhoneNumber(String phoneNumber);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.nickname=:nickname,u.avatarUrl=:avatarUrl,u.gender=:gender, u.wangwang=:wangwang,u.alipayId=:alipayId,u.alipayName=:alipayName,u.height=:height, u.weight=:weight where u.id=:id")
    void updateMote(@Param("id") Integer id, @Param("nickname") String nickname,
                    @Param("avatarUrl") String avatarUrl, @Param("gender") Integer gender, @Param("wangwang") String wangwang,
                    @Param("alipayId") String alipayId, @Param("alipayName") String alipayName, @Param("height") Integer height,
                    @Param("weight") Integer weight);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.nickname=:nickname,u.shopName=:shopName,u.email=:email,u.weixin=:weixin,u.referee=:referee where u.id=:id")
    void updateSeller(@Param("id") Integer id, @Param("nickname") String nickname, @Param("shopName") String shopName, @Param("email") String email, @Param("weixin") String weixin, @Param("referee") String referee);

    User findByIdAndPassword(Integer userId, String password);


}
