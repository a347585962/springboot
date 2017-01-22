package com.songlin.springdemo.mapper;

import com.songlin.springdemo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

	/**
	 * 查询所有用户
	 * @return
	 */
	@Select("select * from user")
	public List<User> findUserInfo();//

	/***
	 *  根据id查询用户
	 * @param id  用户id
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	public User findUserById(long id);

	/***
	 * 增加用户
	 * @param user
	 * @return
	 */
	@Insert("insert into user(name, password) valuse(#{name}, #{password})")
	public int addUser(User user);

	/***
	 * 修改密码
	 * @param user
	 * @return
	 */
	@Update("update user set password = #{password} where id = #{id}")
	public int updatePwd(User user);

	/***
	 * 删除用户
	 * @param id 用户id
 	 * @return
	 */
	@Delete("delete from user where id = #{id}")
	public int deleteUser(long id);

}
