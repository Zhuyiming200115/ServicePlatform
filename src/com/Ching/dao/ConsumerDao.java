package com.Ching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Ching.model.Consumer;
import com.Ching.model.Freelance;

public class ConsumerDao {

	//添加
		public int add(Connection con,Consumer consumer) throws Exception{
			
			
			//sql语句
			//String sql_1="select * from freelance where Free_Id=?";//查询编号是否存在
			//PreparedStatement pstmt1 = con.prepareStatement(sql_1);
			
			//pstmt1.setString(1, freelance.getFree_Id());
			//ResultSet rs1 = pstmt1.executeQuery();//查询结果	
			
				
			String sql_2 = "insert into consumer values(?,?,?,?,?)";//插入语句
			PreparedStatement pstmt2 = con.prepareStatement(sql_2);
			
			pstmt2.setString(1, consumer.getCon_Id());
			pstmt2.setString(2, consumer.getCon_Name());
			pstmt2.setString(3, consumer.getCon_Phone());
			pstmt2.setString(4, consumer.getCon_Addr());
			pstmt2.setString(5, consumer.getCon_Type());
			
			return pstmt2.executeUpdate() ;
				
			
		}
		
		//查询
		public ResultSet list(Connection con,Consumer consumer)throws Exception {
			StringBuffer sb = new StringBuffer("select * from consumer");
			
			
			if (consumer.getCon_Type()!=null) {
				sb.append(" and Con_Type like '%"+consumer.getCon_Type()+"%'");
				
			}
			PreparedStatement pstmt2 = con.prepareStatement(sb.toString().replace("and", "where"));
			
			return pstmt2.executeQuery();
		}
		
		
		
		
		
		
		
		//删除
				public int delete(Connection con,String Con_Id) throws Exception{
					String sql="delete from consumer where Con_Id=?";
							PreparedStatement pstm=con.prepareStatement(sql);
					pstm.setString(1, Con_Id);
					return pstm.executeUpdate();
					
				}
			
			
			
			//修改
			public int update(Connection con,Consumer consumer)throws Exception {
				String sql="update consumer set Con_Id=?,Con_Type=?,Con_Name=?,Con_Phone=?,Con_Addr=? where Con_Id=?";
				PreparedStatement pstm=con.prepareStatement(sql);
		        pstm.setString(1, consumer.getCon_Id());
		        pstm.setString(2, consumer.getCon_Type());
		        pstm.setString(3, consumer.getCon_Name());
		        pstm.setString(4, consumer.getCon_Phone());
		        pstm.setString(5, consumer.getCon_Addr());
		        
		        
		        pstm.setString(6, consumer.getCon_Id());
		        
		        return pstm.executeUpdate();
			}
				}
		
		
	
	

