package com.Ching.model;

public class Project {
	
	private String  Pro_Id;
	private String  Pro_Time;
	private String  Pro_Free_Id;
	private String  Pro_Con_Id;
	private String  Pro_Content;
	
	
	
	
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Project(String pro_Id, String pro_Time, String pro_Free_Id, String pro_Con_Id, String pro_Content) {
		super();
		Pro_Id = pro_Id;
		Pro_Time = pro_Time;
		Pro_Free_Id = pro_Free_Id;
		Pro_Con_Id = pro_Con_Id;
		Pro_Content = pro_Content;
	}



	public String getPro_Id() {
		return Pro_Id;
	}
	public void setPro_Id(String pro_Id) {
		Pro_Id = pro_Id;
	}
	public String getPro_Time() {
		return Pro_Time;
	}
	public void setPro_Time(String pro_Time) {
		Pro_Time = pro_Time;
	}
	public String getPro_Free_Id() {
		return Pro_Free_Id;
	}
	public void setPro_Free_Id(String pro_Free_Id) {
		Pro_Free_Id = pro_Free_Id;
	}
	public String getPro_Con_Id() {
		return Pro_Con_Id;
	}
	public void setPro_Con_Id(String pro_Con_Id) {
		Pro_Con_Id = pro_Con_Id;
	}
	public String getPro_Content() {
		return Pro_Content;
	}
	public void setPro_Content(String pro_Content) {
		Pro_Content = pro_Content;
	}
	
	
	
	
	

}
