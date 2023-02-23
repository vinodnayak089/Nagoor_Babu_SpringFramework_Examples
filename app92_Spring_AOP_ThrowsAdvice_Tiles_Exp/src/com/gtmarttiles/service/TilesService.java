package com.gtmarttiles.service;

import com.gtmarttiles.dto.Tiles;

public interface TilesService {
	
	public void getTilesDetails(Tiles tile, String string) throws Exception;
	public void displayTilesDetails(Tiles tile, String string) throws Exception;

}
