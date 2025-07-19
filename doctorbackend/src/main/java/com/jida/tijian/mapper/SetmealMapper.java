package com.jida.tijian.mapper;

import com.jida.tijian.domain.Setmeal;

public interface SetmealMapper {
    int deleteByPrimaryKey(Integer smId);

    int insert(Setmeal record);

    int insertSelective(Setmeal record);

    Setmeal selectByPrimaryKey(Integer smId);

    int updateByPrimaryKeySelective(Setmeal record);

    int updateByPrimaryKey(Setmeal record);
}