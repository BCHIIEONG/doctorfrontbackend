package com.jida.tijian.mapper;

import com.jida.tijian.domain.Cireport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CireportMapper {
    int deleteByPrimaryKey(Integer cirId);

    int insert(Cireport record);

    int insertSelective(Cireport record);

    @Select("select  cirId, ciId, ciName, orderId  from cireport where orderId=#{orderId}")
    List<Cireport> selectByOrderId(Integer orderId);

    @Select("select c.ciId,c.ciName\n" +
            "from setmeal s,setmealdetailed sd,checkitem c\n" +
            "where s.smId=sd.smId\n" +
            "\t\t\tand\n" +
            "\t\t\tsd.ciId=c.ciId\n" +
            "\t\t\tand s.smId=#{smId}")
    List<Cireport> selectBySmId(Integer smId);

    Cireport selectByPrimaryKey(Integer cirId);

    int updateByPrimaryKeySelective(Cireport record);

    int updateByPrimaryKey(Cireport record);
}