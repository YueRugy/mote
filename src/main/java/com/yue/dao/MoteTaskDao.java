package com.yue.dao;

import com.yue.entity.MoteTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/13
 */
@Repository
public interface MoteTaskDao extends JpaRepository<MoteTask, Integer>, JpaSpecificationExecutor<MoteTask> {
    @Query("select count(id) from MoteTask where userId=:userId and acceptedTime=current_date")
    Integer countByUserIdAndDate(@Param("userId") Integer userId);

    MoteTask findByUserIdAndTaskId(Integer moteId, Integer taskId);

    Page<MoteTask> findAll(Specification<MoteTask> specification, Pageable pageable);
}
