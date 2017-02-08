package com.yue.dao;

import com.yue.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/8
 */
@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
}
