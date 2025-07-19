package com.jida.tijian.mapper;

import com.jida.tijian.domain.Overallresult;

public interface OverallresultMapper {
    int deleteByPrimaryKey(Integer orId);

    int insert(Overallresult record);

    int insertSelective(Overallresult record);

    Overallresult selectByPrimaryKey(Integer orId);

    int updateByPrimaryKeySelective(Overallresult record);

    int updateByPrimaryKey(Overallresult record);
}