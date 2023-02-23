package com.gtmarttiles.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;

public class TilesRowMapper implements RowMapper<Tiles> {

	@Override
	public Tiles mapRow(ResultSet rs, int arg1) throws SQLException {
        Tiles tiles=new Tiles();
        Quantity quantity=new Quantity();
        tiles.setDesignNo(rs.getString("DESIGN_NO"));
        tiles.setBoxSize(rs.getString("BOX_SIZE"));
        quantity.setL(rs.getInt("L"));
        quantity.setHl(rs.getInt("HL"));
        quantity.setD(rs.getInt("D"));
        quantity.setF(rs.getInt("F"));
        tiles.setQuantity(quantity);
        tiles.setPrize(rs.getInt("PRIZE"));
        
		return tiles;
	}
	
	

}
