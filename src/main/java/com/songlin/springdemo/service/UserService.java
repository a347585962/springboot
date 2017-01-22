package com.songlin.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.songlin.springdemo.mapper.UserMapper;
import com.songlin.springdemo.model.User;

import java.util.List;

@Repository
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUserInfo() {
		
		List<User> users = userMapper.findUserInfo();
		return users;
	}
}
