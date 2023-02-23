package com.gtmarttiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.factory.ConnectionFactory;

public class TilesRepoImpl implements TilesRepo {

	@Override
	public String add(Tiles tiles) {
		String status = "";
		try {

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM TILES WHERE DESIGN_NO=?");
			pst.setString(1, tiles.getDesignNo());
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				Quantity quantity = tiles.getQuantity();
				pst = con.prepareStatement("INSERT INTO TILES VALUES(:boxSize,:designNo,:l,:hl,:d,:f,:prize)");
				pst.setString(1, tiles.getBoxSize());
				pst.setString(2, tiles.getDesignNo());
				pst.setInt(3, quantity.getL());
				pst.setInt(4, quantity.getHl());
				pst.setInt(5, quantity.getD());
				pst.setInt(6, quantity.getF());
				pst.setInt(7, tiles.getPrize());
				int rowCount = pst.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else
					status = "failure";
			}
		} catch (Exception e) {

			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Tiles searchtiles(String designNo) {
		Tiles tiles = new Tiles();
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM TILES WHERE DESIGN_NO=?");
			pst.setString(1, designNo);
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true) {
				Quantity quantity = new Quantity();
				tiles.setDesignNo(rs.getString("DESIGN_NO"));
				tiles.setBoxSize(rs.getString("BOX_SIZE"));
				quantity.setL(rs.getInt("L"));
				quantity.setHl(rs.getInt("HL"));
				quantity.setD(rs.getInt("D"));
				quantity.setF(rs.getInt("F"));
				tiles.setQuantity(quantity);
				tiles.setPrize(rs.getInt("PRIZE"));
			} else
				tiles = null;
		} catch (Exception e) {
			tiles = null;
			e.printStackTrace();
		}
		return tiles;
	}

	@Override
	public String update(Tiles tiles) {
		String status = "";
		Connection con = ConnectionFactory.getConnection();
		try {
			String query = "UPDATE TILES SET BOX_SIZE=:boxSize, L=:l, HL=:hl, D=:d, F=:f,PRIZE=:prize WHERE DESIGN_NO=:designNo";
			PreparedStatement pst = con.prepareStatement(query);
			Quantity quantity = tiles.getQuantity();
			pst.setString(1, tiles.getBoxSize());
			pst.setString(7, tiles.getDesignNo());
			pst.setInt(2, quantity.getL());
			pst.setInt(3, quantity.getHl());
			pst.setInt(4, quantity.getD());
			pst.setInt(5, quantity.getF());
			pst.setInt(6, tiles.getPrize());
			int rowCount = pst.executeUpdate();
			if (rowCount == 1) {
				status = "success";
			} else
				status = "failure";
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(String designNo) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM TILES WHERE DESIGN_NO=?");
			pst.setString(1, designNo);
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true) {
				pst = con.prepareStatement("DELETE FROM TILES WHERE DESIGN_NO=?");
				pst.setString(1, designNo);
				int rowCount = pst.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}

			} else {
				status = "notexisted";
			}

		} catch (Exception e) {
			status = "failure";
		}
		return status;
	}

}
