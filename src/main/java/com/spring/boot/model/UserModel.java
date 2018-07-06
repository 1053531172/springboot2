package com.spring.boot.model;

import java.io.Serializable;

public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 获取用户id
	 *@return Integer 用户id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置用户id
	 *@param userId 用户id
	 *@return void
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取用户名称
	 *@return String 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名称
	 *@param userName 用户名称
	 *@return void
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取用户密码
	 *@return String 用户密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置用户密码
	 *@param password 用户密码
	 *@return void
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取电话
	 *@return String 电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置电话
	 *@param phone 电话
	 *@return void
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
