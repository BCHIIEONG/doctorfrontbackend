package com.jida.tijian.mapper;

import com.jida.tijian.domain.Cidetailedreport;

public interface CidetailedreportMapper {
    int deleteByPrimaryKey(Integer cidrId);

    int insert(Cidetailedreport record);

    int insertSelective(Cidetailedreport record);

    Cidetailedreport selectByPrimaryKey(Integer cidrId);

    int updateByPrimaryKeySelective(Cidetailedreport record);

    int updateByPrimaryKey(Cidetailedreport record);
}