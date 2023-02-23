package com.gtmarttiles.dto;

import java.io.File;

public class Customer{
	
	private String name;
	private int cno;
	private File cus_Img;
	private File cus_Resume;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public File getCus_Img() {
		return cus_Img;
	}
	public void setCus_Img(File cus_Img) {
		this.cus_Img = cus_Img;
	}
	public File getCus_Resume() {
		return cus_Resume;
	}
	public void setCus_Resume(File cus_Resume) {
		this.cus_Resume = cus_Resume;
	}
	
	@Override
	public String toString() {
		return cno+" "+name+" "+cus_Img.getAbsolutePath()+" "+cus_Resume.getAbsolutePath();
	}

}
