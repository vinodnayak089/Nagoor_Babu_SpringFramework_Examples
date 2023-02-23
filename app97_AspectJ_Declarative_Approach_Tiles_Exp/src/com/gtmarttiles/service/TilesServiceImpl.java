package com.gtmarttiles.service;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;

public class TilesServiceImpl implements TilesService {
	
	Quantity quantity;

	@Override
	public void getTilesDetails(Tiles tile) {
        System.out.println("*** method getTilesDetails ***");
        System.out.println("Email :"+tile.getEmail());
        System.out.println("Mobile number : "+tile.getMobileNum());
	}
}
