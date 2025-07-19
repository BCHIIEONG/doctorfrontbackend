package com.jida.tijian.mapper;

import com.jida.tijian.domain.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(Integer hpId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(Integer hpId);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKeyWithBLOBs(Hospital record);

    int updateByPrimaryKey(Hospital record);
}