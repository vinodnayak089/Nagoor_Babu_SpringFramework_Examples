package com.gtmarttiles.entity;

public class Tiles {

	private String boxSize;
	private String designNo;
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

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "BoxSize :" + boxSize + ", " + "DesignNo :" + designNo + ", " + "Prize :" + prize;
	}

}
