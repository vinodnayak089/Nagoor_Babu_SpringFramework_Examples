package com.gtmarttiles.service;

import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.expections.InvalidDesignNumber;

public interface TilesService {
	
	public void getTilesDetails(Tiles tile) throws InvalidDesignNumber;

}
