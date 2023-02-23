package com.gtmarttiles.dao;

import java.util.List;

import com.gtmarttiles.dto.Tiles;

public interface Repo {
	
	public Tiles searchtiles(String designNo);
	public String update(Tiles tiles);
	public String delete(String designNo);
	public int[] add(List<Tiles> list);

}
