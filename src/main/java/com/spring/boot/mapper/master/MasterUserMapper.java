package com.spring.boot.mapper.master;

import java.util.List;

import com.spring.boot.model.UserModel;

public interface MasterUserMapper {
	
	/**
	 * 获取全部用户数据
	 *@return List<UserModel> 用户列表
	 */
	List<UserModel> getAll();
	
	/**
	 * 获取用户数据
	 *@param userId 用户id
	 *@return UserModel 用户数据
	 */
	UserModel get(Integer userId);
	
	/**
	 * 保存用户
	 *@param userModel 用户数据
	 *@return Integer 是否成功，1成功，0失败
	 */
	Integer insert(UserModel userModel);
	
	/**
	 * 更新用户
	 *@param userModel 用户数据
	 *@return Integer 是否成功，1成功，0失败
	 */
	Integer update(UserModel userModel);
	
	/**
	 * 删除用户
	 *@param userId 用户id
	 *@return Integer 是否成功，1成功，0失败
	 */
	Integer delete(Integer userId);
}
