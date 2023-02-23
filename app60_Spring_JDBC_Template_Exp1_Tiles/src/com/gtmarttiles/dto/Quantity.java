package com.gtmarttiles.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Quantity {

	private int l;
	private int hl;
	private int d;
	private int f;

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getHl() {
		return hl;
	}

	public void setHl(int hl) {
		this.hl = hl;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "Light :" + l + ", " + "Highlighter :" + hl + ", " + "Dark :" + d + ", " + "Flooring :" + f;
	}

}
