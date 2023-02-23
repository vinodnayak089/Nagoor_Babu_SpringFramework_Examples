package com.gtmarttiles.dao;

import com.gtmarttiles.dto.Tiles;

public interface TilesRepo {
	
	public String add(Tiles tiles);
	public Tiles searchtiles(String designNo);
	public String update(Tiles tiles);
	public String delete(String designNo);

}
