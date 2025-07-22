package com.neusoft.tijiancms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.tijiancms.po.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users where userId=#{userId}")
	public Users getUsersById(String userId);
}
