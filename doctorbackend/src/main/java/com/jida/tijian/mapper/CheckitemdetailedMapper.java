package com.jida.tijian.mapper;

import com.jida.tijian.domain.Checkitemdetailed;

public interface CheckitemdetailedMapper {
    int deleteByPrimaryKey(Integer cdId);

    int insert(Checkitemdetailed record);

    int insertSelective(Checkitemdetailed record);

    Checkitemdetailed selectByPrimaryKey(Integer cdId);

    int updateByPrimaryKeySelective(Checkitemdetailed record);

    int updateByPrimaryKey(Checkitemdetailed record);
}