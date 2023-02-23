package com.durgasoft.beans;

public class EmployeeAddress {
	
	private String hno;
	private String street;
	private String area;
	private String state;
	
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "EmployeeAddress [hno=" + hno + ", street=" + street + ", area=" + area + ", state=" + state + "]";
	}

}
