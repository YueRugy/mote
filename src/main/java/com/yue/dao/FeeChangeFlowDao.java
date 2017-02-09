package com.yue.dao;

import com.yue.entity.FeeChangeFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/2/9
 */
@Repository
public interface FeeChangeFlowDao extends JpaRepository<FeeChangeFlow, Integer> {
}
