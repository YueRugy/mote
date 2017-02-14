package com.yue.dao;

import com.yue.entity.VideoMoteTask;
import com.yue.entity.VideoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/14
 */
@Repository
public interface VideoMoteTaskDao extends JpaRepository<VideoMoteTask, Integer>, JpaSpecificationExecutor<VideoMoteTask> {

    VideoMoteTask findByUserIdAndVideoTask(Integer userId, VideoTask videoTask);
}
