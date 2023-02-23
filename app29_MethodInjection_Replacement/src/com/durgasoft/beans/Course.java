package com.durgasoft.beans;

public class Course {
	
	private String cname;
	private String ccost;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcost() {
		return ccost;
	}
	public void setCcost(String ccost) {
		this.ccost = ccost;
	}
	
	@Override
	public String toString() {
		return "Course [cname=" + cname + ", ccost=" + ccost + "]";
	}
	
	public void getCourseDeatils() {
		System.out.println("course name : "+cname);
		System.out.println("couse  ccost :"+ccost);
	}
}
