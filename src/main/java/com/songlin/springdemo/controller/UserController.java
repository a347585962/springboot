package com.songlin.springdemo.controller;

import com.songlin.springdemo.model.User;
import com.songlin.springdemo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUserList(){

		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		List<User> users = service.getUserInfo();
		System.out.println("查询用户");

		return users;
	}

	@ApiOperation(value = "获取单一用户", notes = "根据id获取")
	@ApiImplicitParam(name = "id", value = "用户详细实体id", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable long id){

		// url中的id可通过@PathVariable绑定到函数的参数中
		//@RequestParam(value = "id",required = false, defaultValue = "111")
		User user = service.getUserInfoById(id);
		System.out.println("根据id查询用户" + id);
		return user;

	}

	/***
	 *
	 * @param id
	 * @param name
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "增加用户", notes = "增加用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")
	})
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public int addUser(@ModelAttribute long id,@ModelAttribute String name, @ModelAttribute String password){

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		int result = service.addUser(user);
		return result;

	}

	/***
	 * 修改密码
	 * @return
	 */
	@ApiOperation(value = "修改密码", notes = "")
	@ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public int updatePwd(@ModelAttribute User user){

		int result = service.updatePwd(user);
		return result;
	}

	/***
	 *  删除用户
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除用户", notes = "")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public int deleteUser(@ModelAttribute long id){

		int result = service.deleteUser(id);
		return result;

	}


}
