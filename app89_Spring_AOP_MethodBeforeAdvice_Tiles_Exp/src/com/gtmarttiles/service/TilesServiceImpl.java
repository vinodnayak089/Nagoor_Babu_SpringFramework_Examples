package com.gtmarttiles.service;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;

public class TilesServiceImpl implements TilesService {
	
	Quantity quantity;

	@Override
	public void getTilesDetails(Tiles tile) {
        System.out.println("*** method getTilesDetails ***");
        System.out.println(tile.getBoxSize());
        System.out.println(tile.getDesignNo());
        quantity = tile.getQuantity();
        System.out.println(quantity.getL());
        System.out.println(quantity.getHl());
        System.out.println(quantity.getD());
        System.out.println(quantity.getF());
        System.out.println(tile.getPrize());
        System.out.println(tile.getEmail());
        System.out.println(tile.getMobileNum());
	}

	@Override
	public void displayTilesDetails(Tiles tile) {

		System.out.println("*** method displayTilesDetails ***");
        System.out.println(tile.getBoxSize());
        System.out.println(tile.getDesignNo());
        quantity = tile.getQuantity();
        System.out.println(quantity.getL());
        System.out.println(quantity.getHl());
        System.out.println(quantity.getD());
        System.out.println(quantity.getF());
        System.out.println(tile.getPrize());
        System.out.println(tile.getEmail());
        System.out.println(tile.getMobileNum());
	}

}
