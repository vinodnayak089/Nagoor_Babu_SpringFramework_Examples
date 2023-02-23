package com.gtmarttiles.dao;

import com.gtmarttiles.entity.Tiles;

public interface TilesDao {
	
	public String insert(Tiles tiles);
	public String update(Tiles tiles);
	public void delete(String designNo);
	public Tiles get(String designNo);

}
