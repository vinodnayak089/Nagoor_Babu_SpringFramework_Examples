package com.gtmarttiles.dto;

import javax.persistence.Entity;

@Entity
public class Tiles {

	private String boxSize;
	private String designNo;
	private Quantity quantity;
	private int prize;
	private String email;
	private String mobileNum;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getBoxSize() {
		return boxSize;
	}

	public void setBoxSize(String size) {
		this.boxSize = size;
	}

	public String getDesignNo() {
		return designNo;
	}

	public void setDesignNo(String designNo) {
		this.designNo = designNo;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "BoxSize :" + boxSize + ", " + "DesignNo :" + designNo + ", " + "Quantity :[" + quantity + "], "
				+ "Prize :" + prize + "email :" + email + "mobileNum :" + mobileNum;
	}

}
