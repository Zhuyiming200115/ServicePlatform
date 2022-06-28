package com.Ching.model;



//自由职业者实体
public class Freelance {

	
	private String  Free_Id;
	private String  Free_Type;
	private String  Free_Name;
	private String  Free_Phone;
	private String  Free_Addr;
	
	
	
	public Freelance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public Freelance(String free_Id, String free_Type, String free_Name, String free_Phone, String free_Addr) {
		super();
		Free_Id = free_Id;
		Free_Type = free_Type;
		Free_Name = free_Name;
		Free_Phone = free_Phone;
		Free_Addr = free_Addr;
	}






	public Freelance(String free_Name, String free_Phone, String free_Addr) {
		super();
		Free_Name = free_Name;
		Free_Phone = free_Phone;
		Free_Addr = free_Addr;
	}


	
	

	




	public String getFree_Id() {
		return Free_Id;
	}

	public void setFree_Id(String free_Id) {
		Free_Id = free_Id;
	}

	public String getFree_Type() {
		return Free_Type;
	}

	public void setFree_Type(String free_Type) {
		Free_Type = free_Type;
	}

	public String getFree_Name() {
		return Free_Name;
	}
	public void setFree_Name(String free_Name) {
		Free_Name = free_Name;
	}
	public String getFree_Phone() {
		return Free_Phone;
	}
	public void setFree_Phone(String free_Phone) {
		Free_Phone = free_Phone;
	}
	public String getFree_Addr() {
		return Free_Addr;
	}
	public void setFree_Addr(String free_Addr) {
		Free_Addr = free_Addr;
	}
	
	
	
	
	
	
	
	
	
	
}
