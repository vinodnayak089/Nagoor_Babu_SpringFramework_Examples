package com.durgasoft.beans;

public class Student {
	
	private int sid;
	private String sname;
	private String saddr;
	private Course course;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public void dispalyStudentDetails() {
		System.out.println("Student id : "+sid);
		System.out.println("Student id : "+sname);
		System.out.println("Student id : "+saddr);
		System.out.println("Course Deatils : "+course);
	}
	
}
