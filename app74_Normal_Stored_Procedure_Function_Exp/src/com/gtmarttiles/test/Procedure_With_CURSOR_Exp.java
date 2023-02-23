package com.gtmarttiles.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

/*
 create or replace procedure getTiles(designNo IN string, outTiles OUT SYS_REFCURSOR)
 AS
 BEGIN
   open for outTiles select *from tiles where design_no < designNo;
   END getTiles;
   /
 
 */

public class Procedure_With_CURSOR_Exp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
    
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","system");
        CallableStatement cst=con.prepareCall("{call getTiles(?,?)}");
        cst.setString(1, "AAAAA");
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs= (ResultSet) cst.getObject(2);
        System.out.println("Box Size Design No Light HightLighter Dark Flooring prize");
        System.out.println("----------------------------------------------------------------------------------");
        while(rs.next())
        {
        	System.out.print(rs.getString("BOX_SIZE")+"\t"); 
			System.out.print(rs.getString("DESIGN_NO")+"\t");
			System.out.print(rs.getInt("L")+"\t");
			System.out.print(rs.getInt("HL")+"\t");
			System.out.print(rs.getInt("D")+"\t");
			System.out.print(rs.getInt("F")+"\t");
			System.out.print(rs.getInt("PRIZE")+"\n");
        }
		
	}

}
