package com.Ching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Ching.model.Consumer;
import com.Ching.model.Project;
import com.Ching.model.Schedule;

public class ScheduleDao {

	
	//添加
			public int add(Connection con,Schedule schedule) throws Exception{
				
				
				//sql语句
				//String sql_1="select * from freelance where Free_Id=?";//查询编号是否存在
				//PreparedStatement pstmt1 = con.prepareStatement(sql_1);
				
				//pstmt1.setString(1, freelance.getFree_Id());
				//ResultSet rs1 = pstmt1.executeQuery();//查询结果	
				
					
				String sql_2 = "insert into schedule values(?,?,?)";//插入语句
				PreparedStatement pstmt2 = con.prepareStatement(sql_2);
				
				pstmt2.setString(1, schedule.getSch_Id());
				pstmt2.setString(2, schedule.getSch_Time());
				pstmt2.setString(3, schedule.getSch_Free_Id());
				
				
				return pstmt2.executeUpdate() ;
					
				
			}
			
			//查询
			public ResultSet list(Connection con,Schedule schedule)throws Exception {
				StringBuffer sb = new StringBuffer("select * from schedule");
				
				
				if (schedule.getSch_Id()!=null) {
					sb.append(" and Sch_Id like '%"+schedule.getSch_Id()+"%'");
					
				}
				PreparedStatement pstmt2 = con.prepareStatement(sb.toString().replace("and", "where"));
				
				return pstmt2.executeQuery();
			}
	
	
			//删除
			public int delete(Connection con,String Sch_Id) throws Exception{
				String sql="delete from schedule where Sch_Id=?";
						PreparedStatement pstm=con.prepareStatement(sql);
				pstm.setString(1, Sch_Id);
				return pstm.executeUpdate();
				
			}
		
		
		
		//修改
		public int update(Connection con,Schedule schedule)throws Exception {
			String sql="update schedule set Sch_Id=?,Sch_Free_Id=?,Sch_Time=?where Sch_Id=?";
			PreparedStatement pstm=con.prepareStatement(sql);
	        pstm.setString(1, schedule.getSch_Id());
	        pstm.setString(2, schedule.getSch_Free_Id());
	        pstm.setString(3, schedule.getSch_Time());
	        
	        
	        
	        pstm.setString(4, schedule.getSch_Id());
	        
	        return pstm.executeUpdate();
		}
			
			
	
	
}
