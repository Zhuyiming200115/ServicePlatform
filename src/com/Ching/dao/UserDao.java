package com.Ching.dao;

import java.sql.Connection;

import com.Ching.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;




public class UserDao {
	//登陆验证
	public User login(Connection con,User user)throws Exception{
		User resultUser = null;
		
		//sql语句：查询对应用户
		String sql = "select * from user where User_Name=?and password=?"; 
		PreparedStatement pstmt = con.prepareStatement(sql); 
		
		pstmt.setString(1, user.getUser_Name());//接受界面传过来的用户名
		pstmt.setString(2, user.getPassword());//接受界面传过来的密码
		
		ResultSet rs = pstmt.executeQuery();//查询结果
		if (rs.next()) {
			resultUser = new User();
			resultUser.setUser_Id(rs.getInt("User_Id"));
			resultUser.setUser_Name(rs.getString("User_Name"));
			resultUser.setUser_Type(rs.getInt("User_Type"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
	
	
	
}
