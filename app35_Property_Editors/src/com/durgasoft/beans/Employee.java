package com.durgasoft.beans;

public class Employee {
	
	private int eid;
	private String ename;
	private EmployeeAddress eaddr;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public EmployeeAddress getEaddr() {
		return eaddr;
	}
	public void setEaddr(EmployeeAddress eaddr) {
		this.eaddr = eaddr;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddr=" + eaddr + "]";
	}
	
	

}
