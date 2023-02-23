package com.gtmarttiles.dao;

import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.mapper.TilesRowMapper;

public class RepoImpl extends JdbcDaoSupport implements Repo {

	@Override
	public String add(Tiles tiles) {
		String status = "";
		try {
			String query = "SELECT * FROM TILES WHERE DESIGN_NO= :designNo";
			List<Tiles> tilesData = getJdbcTemplate().query(query, new Object[] { tiles.getDesignNo() },
					new TilesRowMapper());
			if (tilesData.isEmpty()) {
				query = "INSERT INTO TILES VALUES(:boxSize,:designNo,:l,:hl,:d,:f,:prize)";
				Quantity quantity = tiles.getQuantity();
				int rowCount = getJdbcTemplate().update(query, new Object[] { tiles.getBoxSize(), tiles.getDesignNo(),
						quantity.getL(), quantity.getHl(), quantity.getD(), quantity.getF(), tiles.getPrize() });
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
			List<Tiles> tilesList = getJdbcTemplate().query(query, new Object[] { designNo }, new TilesRowMapper());
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
			Quantity quantity = tiles.getQuantity();
			String query = "UPDATE TILES SET BOX_SIZE=:boxSize, L=:l, HL=:hl, D=:d, F=:f,PRIZE=:prize WHERE DESIGN_NO=:designNo";
			int rowCount = getJdbcTemplate().update(query, new Object[] { tiles.getBoxSize(), quantity.getL(),
					quantity.getHl(), quantity.getD(), quantity.getF(), tiles.getPrize(), tiles.getDesignNo() });
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
			int rowCount = getJdbcTemplate().update(query, new Object[] { designNo });
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
