package com.gtmarttiles.factory;

import com.gtmarttiles.dao.TilesRepo;
import com.gtmarttiles.dao.TilesRepoImpl;

public class TilesDaoFactory {
	
	private static TilesRepo tilesRepo;
	
	static {
		tilesRepo=new TilesRepoImpl();
	}
	
	public static TilesRepo getTilesRepo() {
		return tilesRepo;
		
	}

}
 