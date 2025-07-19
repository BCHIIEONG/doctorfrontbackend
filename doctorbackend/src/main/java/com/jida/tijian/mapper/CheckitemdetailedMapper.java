package com.jida.tijian.mapper;

import com.jida.tijian.domain.Checkitemdetailed;
import com.jida.tijian.domain.Cidetailedreport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckitemdetailedMapper {
    int deleteByPrimaryKey(Integer cdId);

    int insert(Checkitemdetailed record);

    int insertSelective(Checkitemdetailed record);

    Checkitemdetailed selectByPrimaryKey(Integer cdId);

    int updateByPrimaryKeySelective(Checkitemdetailed record);

    int updateByPrimaryKey(Checkitemdetailed record);

    @Select("select cd.cdId, cd.name, cd.unit, cd.minrange, cd.maxrange, cd.normalValue, cd.normalValueString,cd.type,cd.ciId " +
            "from setmeal s,setmealdetailed sd,checkitem c,checkitemdetailed cd\n" +
            "where s.smId=sd.smId\n" +
            "\t\t\tand\n" +
            "\t\t\tsd.ciId=c.ciId\n" +
            "\t\t\tand \n" +
            "\t\t\tc.ciId=cd.ciId\n" +
            "\t\t\tand\n" +
            "\t\t\ts.smId=#{smId}")
    List<Cidetailedreport> selectBySmId(Integer smId);
}