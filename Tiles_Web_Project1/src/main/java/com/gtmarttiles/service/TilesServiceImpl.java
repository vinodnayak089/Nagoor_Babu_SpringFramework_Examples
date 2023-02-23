package com.gtmarttiles.service;

import com.gtmarttiles.dao.TilesRepo;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.factory.TilesDaoFactory;

public class TilesServiceImpl implements TilesService {

	TilesRepo tilesRepo=TilesDaoFactory.getTilesRepo();
	
	@Override
	public String add(Tiles tiles) throws Exception{
		return tilesRepo.add(tiles);
	}

	@Override
	public Tiles searchtiles(String designNo) {
		return tilesRepo.searchtiles(designNo);
	}

	@Override
	public String update(Tiles tiles) {
		return tilesRepo.update(tiles);
	}

	@Override
	public String delete(String designNo) {
		return tilesRepo.delete(designNo);
	}

}
