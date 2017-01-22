package com.songlin.springdemo.controller;

import com.songlin.springdemo.model.User;
import com.songlin.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;

	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUserList(){

		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		List<User> users = service.getUserInfo();
		System.out.println("查询用户");

		return users;
	}

	@RequestMapping(value = "/#{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable long id){

		// url中的id可通过@PathVariable绑定到函数的参数中
		//@RequestParam(value = "id",required = false, defaultValue = "111")
		User user = service.getUserInfoById(id);
		return user;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int addUser(User user){

		int result = service.addUser(user);
		return result;

	}


}
