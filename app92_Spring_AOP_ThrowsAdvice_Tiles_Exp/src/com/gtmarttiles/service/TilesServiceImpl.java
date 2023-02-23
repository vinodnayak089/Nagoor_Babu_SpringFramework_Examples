package com.gtmarttiles.service;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;

public class TilesServiceImpl implements TilesService {
	
	Quantity quantity;

	@Override
	public void getTilesDetails(Tiles tile, String customerName) throws Exception{
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
        	throw new RuntimeException("provided wrong design number");
	}

	@Override
	public void displayTilesDetails(Tiles tile, String customerName) throws Exception{

		System.out.println("*** method displayTilesDetails ***");
        System.out.println(tile.getBoxSize());
        System.out.println(tile.getDesignNo());
        	throw new RuntimeException("provided wrong design number");
//        quantity = tile.getQuantity();
//        System.out.println(quantity.getL());
//        System.out.println(quantity.getHl());
//        System.out.println(quantity.getD());
//        System.out.println(quantity.getF());
//        System.out.println(tile.getPrize());
       
//        System.out.println(tile.getEmail());
//        System.out.println(tile.getMobileNum());
//        System.out.println(customerName);
	}

}
