package com.gtmarttiles.test;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClobInsert {

	public static void main(String[] args) {

		Connection con = null;
		FileReader fr = null;
		PreparedStatement pst = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "system");
			pst = con.prepareStatement("insert into tiles_docs values(?,?)");
			File file = new File("D:/GT_MART_Images/applicationContext.xml");
			fr = new FileReader(file);
			pst.setString(1, "applicationContext");
			pst.setCharacterStream(2, fr, (int) file.length());
			int rowCount = pst.executeUpdate();
			if (rowCount == 1) {
				System.out.println("Document insertion successfull");
			} else
				System.out.println("Document insertion failed");
		} catch (Exception e) {
			System.out.println("Document insertion failed");
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				con.close();
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
