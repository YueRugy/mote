package com.yue.dao;

import com.yue.entity.VideoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/13
 */
@Repository
public interface VideoTaskDao extends JpaRepository<VideoTask, Integer>, JpaSpecificationExecutor<VideoTask> {
}
