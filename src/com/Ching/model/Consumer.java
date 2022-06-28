package com.Ching.model;

public class Consumer {
	
	private String  Con_Id;
	private String  Con_Type;
	private String  Con_Name;
	private String  Con_Phone;
	private String  Con_Addr;
	
		
	
	public Consumer(String con_Id, String con_Type, String con_Name, String con_Phone, String con_Addr) {
		super();
		Con_Id = con_Id;
		Con_Type = con_Type;
		Con_Name = con_Name;
		Con_Phone = con_Phone;
		Con_Addr = con_Addr;
	}
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCon_Id() {
		return Con_Id;
	}
	public void setCon_Id(String con_Id) {
		Con_Id = con_Id;
	}
	public String getCon_Type() {
		return Con_Type;
	}
	public void setCon_Type(String con_Type) {
		Con_Type = con_Type;
	}
	public String getCon_Name() {
		return Con_Name;
	}
	public void setCon_Name(String con_Name) {
		Con_Name = con_Name;
	}
	public String getCon_Phone() {
		return Con_Phone;
	}
	public void setCon_Phone(String con_Phone) {
		Con_Phone = con_Phone;
	}
	public String getCon_Addr() {
		return Con_Addr;
	}
	public void setCon_Addr(String con_Addr) {
		Con_Addr = con_Addr;
	}
	
	
	
	
	
	
	
	
	

}
