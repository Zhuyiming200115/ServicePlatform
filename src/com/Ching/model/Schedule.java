package com.Ching.model;

public class Schedule {

	private String  Sch_Id;
	private String  Sch_Time;
	private String  Sch_Free_Id;
	
	
	
	
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Schedule(String sch_Id, String sch_Time, String sch_Free_Id) {
		super();
		Sch_Id = sch_Id;
		Sch_Time = sch_Time;
		Sch_Free_Id = sch_Free_Id;
	}





	public String getSch_Id() {
		return Sch_Id;
	}
	public void setSch_Id(String sch_Id) {
		Sch_Id = sch_Id;
	}
	public String getSch_Time() {
		return Sch_Time;
	}
	public void setSch_Type(String sch_Time) {
		Sch_Time = sch_Time;
	}
	public String getSch_Free_Id() {
		return Sch_Free_Id;
	}
	public void setSch_Free_Id(String sch_Free_Id) {
		Sch_Free_Id = sch_Free_Id;
	}
	
	
	
	
}
