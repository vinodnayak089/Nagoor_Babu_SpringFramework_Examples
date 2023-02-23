package com.gtmarttiles.service;

import org.springframework.stereotype.Component;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.expections.InvalidDesignNumber;

@Component("tilesService")
public class TilesServiceImpl implements TilesService {
	
	Quantity quantity;

	@Override
	public void getTilesDetails(Tiles tile) throws InvalidDesignNumber {
        System.out.println("*** method getTilesDetails ***");
        System.out.println("Email :"+tile.getEmail());
        System.out.println("Mobile number : "+tile.getMobileNum());
        if(tile.getDesignNo().equals("undecided"))
        {
            throw new InvalidDesignNumber(" these design number is undecided");	
        }
	}
}
