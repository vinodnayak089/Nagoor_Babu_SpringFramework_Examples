package com.gtmarttiles.factory;

import com.gtmarttiles.service.TilesService;
import com.gtmarttiles.service.TilesServiceImpl;

public class TilesServiceFactory {
	
	private static TilesService tilesService;
	
	static {
		tilesService=new TilesServiceImpl();
	}
	
	public static TilesService getTilesService() {
		return tilesService;
		
	}

}
 