package com.gtmarttiles.dto;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

@Entity
public class Tiles {

	private String boxSize;
	private String designNo;
	private Quantity quantity;
	private int prize;

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
				+ "Prize :" + prize;
	}

//	public static void main(String[] args) {
//		Map<String, Object> map = new HashMap<>();
//		System.out.println("First empty : "+map);
//		map.put("DESIGN_NO", "design2");
//		System.out.println("Adding values : "+map);
//		map=new HashMap<>();
//		System.out.println("Making empty : "+map);
//		map.put("DESIGN_NO", "design2");
//		System.out.println("Second Time : "+map);
//		}
}
