package com.yue.dao;

import com.yue.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/7
 */
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
}
