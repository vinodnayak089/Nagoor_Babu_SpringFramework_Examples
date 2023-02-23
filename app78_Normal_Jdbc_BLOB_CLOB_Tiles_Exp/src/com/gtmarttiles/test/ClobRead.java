package com.gtmarttiles.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClobRead {

	public static void main(String[] args) {

		Connection con = null;
		FileWriter fw = null;
		PreparedStatement pst = null;
		Reader r= null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "system");
			pst = con.prepareStatement("select * from tiles_docs");
			File file = new File("D:/GT_MART_Images/db/applicationContext.xml");
			fw = new FileWriter(file);
		//	pst.setString(1, "gtmart_designs");
		//	pst.setCharacterStream(2, fr, (int) file.length());
			ResultSet rs = pst.executeQuery();
			rs.next();
			rs.next();
			System.out.println("document no :"+rs.getString(1));
			r=rs.getCharacterStream(2);
			int value = r.read();
			while (value != -1) {
				fw.write(value);
				value = r.read();
			}
			
				System.out.println("Document read successfull");
				//System.out.println("Document insertion failed");
		} catch (Exception e) {
			System.out.println("Document read failed");
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				con.close();
				pst.close();
				r.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
