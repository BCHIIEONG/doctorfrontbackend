package com.jida.tijian.mapper;

import com.jida.tijian.domain.Cireport;



public interface CireportMapper {
    int deleteByPrimaryKey(Integer cirId);

    int insert(Cireport record);

    int insertSelective(Cireport record);

    Cireport selectByPrimaryKey(Integer cirId);

    int updateByPrimaryKeySelective(Cireport record);

    int updateByPrimaryKey(Cireport record);
}