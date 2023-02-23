package com.gtmarttiles.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.mapper.TilesRowMapper;

public class RepoImpl implements Repo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int[] add(List<Tiles> list) {
		int[] rowCount = null;
		try {
			String query = "INSERT INTO TILES VALUES(?,?,?,?,?,?,?)";
			rowCount=jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Tiles tiles=list.get(i);
					Quantity quantity=tiles.getQuantity();
					ps.setString(1, tiles.getBoxSize());
					ps.setString(2, tiles.getDesignNo());
					ps.setInt(3, quantity.getL());
					ps.setInt(4, quantity.getHl());
					ps.setInt(5, quantity.getD());
					ps.setInt(6, quantity.getF());
					ps.setInt(7, tiles.getPrize());
				}
				
				@Override
				public int getBatchSize() {
					return list.size();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public Tiles searchtiles(String designNo) {
		Tiles tiles = new Tiles();
		try {
			String query = "SELECT * FROM TILES WHERE DESIGN_NO= :designNo";
			List<Tiles> tilesList = jdbcTemplate.query(query, new Object[] { designNo }, new TilesRowMapper());
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
			int rowCount = jdbcTemplate.update(query, new Object[] { tiles.getBoxSize(), quantity.getL(),
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
			int rowCount = jdbcTemplate.update(query, new Object[] { designNo });
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
