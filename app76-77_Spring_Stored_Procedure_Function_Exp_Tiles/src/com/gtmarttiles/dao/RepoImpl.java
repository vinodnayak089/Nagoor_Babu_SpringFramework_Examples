package com.gtmarttiles.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.mapper.TilesRowMapper;

public class RepoImpl implements Repo {

	private DataSource dataSource;
	private SimpleJdbcCall simpleJdbcCall;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		simpleJdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public String add(Tiles tiles) {
		String status = "";
		try {
			// Procedure method for creating tiles in SQL
			/*
			 * create or replace procedure createTiles(boxSize IN varchar, designNo IN
			 * varchar, l IN number, hl IN number, d IN number, f IN number, prize IN
			 * number) AS BEGIN insert into tiles values (boxSize,designNo,l,hl,d,f,prize);
			 * END createTiles; /
			 * 
			 */
			simpleJdbcCall = simpleJdbcCall.withProcedureName("createTiles");
			Map<String, Object> map = new HashMap<>();
			Quantity quantity = new Quantity();
			quantity = tiles.getQuantity();
			map.put("boxSize", tiles.getBoxSize());
			map.put("designNo", tiles.getDesignNo());
			map.put("l", quantity.getL());
			map.put("hl", quantity.getHl());
			map.put("d", quantity.getD());
			map.put("f", quantity.getF());
			map.put("prize", tiles.getPrize());
			simpleJdbcCall.execute(map);
		} catch (Exception e) {
			status = "Insersion failed";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Tiles searchtiles(String designNo) {
		/*
		 * create or replace procedure getTile(designNo IN STRING, outputTile OUT
		 * SYS_REFCURSOR) AS BEGIN open outputTile for select * from tiles where
		 * design_no=designNo; END getTile; /
		 * 
		 */
		Tiles tiles = new Tiles();
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("getTile");
			simpleJdbcCall= simpleJdbcCall.returningResultSet("outputTile", new TilesRowMapper());
			Map<String, Object> outValue = simpleJdbcCall.execute(designNo);
			tiles = (Tiles) ((ArrayList)outValue.get("outputTile")).get(0);
			System.out.println("search :" + tiles);
		} catch (Exception e) {
			tiles = null;
			e.printStackTrace();
		}
		return tiles;
	}

	@Override
	public String update(Tiles tiles) {
		/*
		 * create or replace procedure updateTiles(boxSize1 IN varchar, designNo1 IN
		 * varchar, l1 IN number, hl1 IN number, d1 IN number, f1 IN number, prize1 IN
		 * number) AS BEGIN update tiles set box_size=boxSize1, l=l1, hl=hl1, d=d1,
		 * f=f1, prize=prize1 where design_no = designNo1; END updateTiles; /
		 * 
		 */
		String status = "";
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("updateTiles");
			Map<String, Object> map = new HashMap<>();
			Quantity quantity = new Quantity();
			quantity = tiles.getQuantity();
			map.put("boxSize1", tiles.getBoxSize());
			map.put("designNo1", tiles.getDesignNo());
			map.put("l1", quantity.getL());
			map.put("hl1", quantity.getHl());
			map.put("d1", quantity.getD());
			map.put("f1", quantity.getF());
			map.put("prize1", tiles.getPrize());
			simpleJdbcCall.execute(map);

		} catch (Exception e) {
			status = "Updation failed";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String designNo) {
		/*
		 * create or replace procedure deleteTile(designNo IN STRING) AS BEGIN delete
		 * tiles where design_no=designNo; END deleteTile; /
		 * 
		 */
		String status = "";
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("deleteTile");
			simpleJdbcCall.execute(designNo);
		} catch (Exception e) {
			status = "Delete Failed";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Tiles> getAllTiles() {
        List<Tiles> tilesList= new ArrayList<>();
		simpleJdbcCall = simpleJdbcCall.withProcedureName("getAllTiles");
		simpleJdbcCall= simpleJdbcCall.returningResultSet("outputTile", new TilesRowMapper());
		Map<String, Object> outValue = simpleJdbcCall.execute();
		tilesList = (ArrayList<Tiles>)outValue.get("outputTile");
		//System.out.println("printing all tiles :" + tilesList);

		return tilesList;
	}

}
