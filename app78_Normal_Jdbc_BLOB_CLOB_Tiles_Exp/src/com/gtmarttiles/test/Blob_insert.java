package com.gtmarttiles.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Blob_insert {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {

		Connection con = null;
		FileInputStream fis = null;
		PreparedStatement pst = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "system");
			pst = con.prepareStatement("insert into tiles_img_table values(?,?)");
			File file = new File("D:/GT_MART_Images/gt_mart_card.jpg");
			fis = new FileInputStream(file);
			pst.setString(1, "business_card");
			pst.setBinaryStream(2, fis, (int) file.length());
			int rowCount = pst.executeUpdate();
			if (rowCount == 1) {
				System.out.println("Tiles image insertion successfull");
			} else
				System.out.println("img insertion failed");
		} catch (Exception e) {
			System.out.println("img insertion failed");
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				con.close();
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
