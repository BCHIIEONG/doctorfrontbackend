package com.jida.tijian.mapper;

import com.jida.tijian.domain.Setmealdetailed;

public interface SetmealdetailedMapper {
    int deleteByPrimaryKey(Integer sdId);

    int insert(Setmealdetailed record);

    int insertSelective(Setmealdetailed record);

    Setmealdetailed selectByPrimaryKey(Integer sdId);

    int updateByPrimaryKeySelective(Setmealdetailed record);

    int updateByPrimaryKey(Setmealdetailed record);
}