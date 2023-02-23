package com.gtmarttiles.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Blob_read {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {

		Connection con = null;
		FileOutputStream fos = null;
		PreparedStatement pst = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "system");
			pst = con.prepareStatement("select * from tiles_img_table");
			File file = new File("D:/GT_MART_Images/db/gt_mart_card_db.jpg");
			fos = new FileOutputStream(file);
			ResultSet rs = pst.executeQuery();
			rs.next();
			System.out.println("design number :" + rs.getString(1));
			InputStream is = rs.getBinaryStream(2);
			int value = is.read();
			while (value != -1) {
				fos.write(value);
				value = is.read();
			}
			System.out.println("Tiles image read successfull");
		} catch (Exception e) {
			System.out.println("img read failed");
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				con.close();
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
