package com.songlin.springdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.songlin.springdemo.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

	/**
	 * 查询所有用户
	 * @return
	 */
	@Select("select * from user")
	public List<User> findUserInfo();//



}
