package com.Ching.model;

/**
 * 用户类
 * 
 * 
 */


public class User {
	
	Integer User_Id;    //用户编号
	String  User_Name;  //用户名
	Integer User_Type;  //用户类型
	String  password;   //用户密码
	
	public User () {
		super();
		
	}
	
	public User (String User_Name,String  password) {
		super();
		this.User_Name = User_Name;
		this.password = password;
	}
	
	
	
	
	public Integer getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(Integer user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public Integer getUser_Type() {
		return User_Type;
	}
	public void setUser_Type(Integer user_Type) {
		User_Type = user_Type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
