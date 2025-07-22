package com.neusoft.tijiancms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.tijiancms.po.CheckItem;

@Mapper
public interface CheckItemMapper {

	public CheckItem getCheckItemById(Integer ciId);
}
