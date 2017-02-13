package com.yue.dao;

import com.yue.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/8
 */
@Repository
public interface TaskDao extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {

    Page<Task> findAllByUserId(Integer id, Pageable pageable);

    Page<Task> findAllByStatus(Integer status, Pageable pageable);


}
