package com.yue.dao;

import com.yue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/7
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByPhoneNumber(String phoneNumber);
}
