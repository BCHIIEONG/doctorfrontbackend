package com.jida.tijian.mapper;

import com.jida.tijian.domain.Checkitem;

public interface CheckitemMapper {
    int deleteByPrimaryKey(Integer ciId);

    int insert(Checkitem record);

    int insertSelective(Checkitem record);

    Checkitem selectByPrimaryKey(Integer ciId);

    int updateByPrimaryKeySelective(Checkitem record);

    int updateByPrimaryKey(Checkitem record);
}