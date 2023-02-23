package com.gtmarttiles.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.mapper.TilesRowMapper;

public class RepoImpl implements Repo {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public String add(Tiles tiles) {
		String status = "";
		try {

			String query = "SELECT * FROM TILES WHERE DESIGN_NO= :designNo";
			Map<String, Object> map = new HashMap<>();
			map.put("designNo", tiles.getDesignNo());
			List<Tiles> tilesData = namedParameterJdbcTemplate.query(query, map, (rs, index) -> {
				Tiles tiles1 = new Tiles();
				Quantity quantity = new Quantity();
				tiles1.setDesignNo(rs.getString("DESIGN_NO"));
				tiles1.setBoxSize(rs.getString("BOX_SIZE"));
				quantity.setL(rs.getInt("L"));
				quantity.setHl(rs.getInt("HL"));
				quantity.setD(rs.getInt("D"));
				quantity.setF(rs.getInt("F"));
				tiles1.setQuantity(quantity);
				tiles1.setPrize(rs.getInt("PRIZE"));
				return tiles;
			});
			if (tilesData.isEmpty()) {
				query = "INSERT INTO TILES VALUES(:boxSize,:designNo,:l,:hl,:d,:f,:prize)";
				Quantity quantity = tiles.getQuantity();
				map = new HashMap<>();
				map.put("boxSize", tiles.getBoxSize());
				map.put("designNo", tiles.getDesignNo());
				map.put("l", quantity.getL());
				map.put("hl", quantity.getHl());
				map.put("d", quantity.getD());
				map.put("f", quantity.getF());
				map.put("prize", tiles.getPrize());
				int rowCount = namedParameterJdbcTemplate.update(query, map);
				if (rowCount == 1) {
					status = "Sucessfully inserted";
				} else
					status = "Insersion failed";
			} else
				status = "Tiles Already Existed";

		} catch (Exception e) {

			status = "Insersion failed";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Tiles searchtiles(String designNo) {
		Tiles tiles = new Tiles();
		try {
			String query = "SELECT * FROM TILES WHERE DESIGN_NO= :designNo";
			Map<String, Object> map = new HashMap<>();
			map.put("designNo", designNo);
			List<Tiles> tilesList = namedParameterJdbcTemplate.query(query, map, new TilesRowMapper());
			if (tilesList.isEmpty()) {
				tiles = null;
			} else
				tiles = tilesList.get(0);
		} catch (Exception e) {
			tiles = null;
			e.printStackTrace();
		}
		return tiles;
	}

	@Override
	public String update(Tiles tiles) {
		String status = "";
		try {
			String query = "UPDATE TILES SET BOX_SIZE=:boxSize, L=:l, HL=:hl, D=:d, F=:f,PRIZE=:prize WHERE DESIGN_NO=:designNo";
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
			int rowCount = namedParameterJdbcTemplate.update(query, map);
			if (rowCount == 1) {
				status = "Sucessfully Updated";
			} else
				status = "Updation failed";
		} catch (Exception e) {
			status = "Updation failed";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String designNo) {
		String status = "";
		try {
			String query = "DELETE FROM TILES WHERE DESIGN_NO= :designNo";
			Map<String, Object> map = new HashMap<>();
			map.put("designNo", designNo);
			int rowCount = namedParameterJdbcTemplate.update(query, map);
			if (rowCount == 1) {
				status = "Sucessfully Deleted";
			} else
				status = "Delete Failed";
		} catch (Exception e) {
			status = "Delete Failed";
			e.printStackTrace();
		}
		return status;
	}

}
