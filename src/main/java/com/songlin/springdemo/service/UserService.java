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

	/***
	 *  获取所有用户
	 * @return
	 */
	public List<User> getUserInfo() {
		
		List<User> users = userMapper.findUserInfo();
		return users;
	}

	/***
	 *  根据id获取用户信息
	 * @param id 用户id
	 * @return
	 */
	public User getUserInfoById(long id){

		User user = userMapper.findUserById(id);
		return user;

	}

	/***
	 *  添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user){

		int result = userMapper.addUser(user);
		return result;

	}

	/***
	 *  修改密码
	 * @param user
	 * @return
	 */
	public int updatePwd(User user){

		int result = userMapper.updatePwd(user);
		return result;

	}

	/***
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(long id){

		int result = userMapper.deleteUser(id);
		return result;

	}

}
