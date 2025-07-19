package com.jida.tijian.mapper;

import com.jida.tijian.domain.Doctor;
import org.apache.ibatis.annotations.Select;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer docId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer docId);

    //注解开发
    @Select("select docId, docCode, realName, password, sex, deptno from doctor where docCode=#{docCode}")
    Doctor selectByDocCode(Doctor doctor);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
}