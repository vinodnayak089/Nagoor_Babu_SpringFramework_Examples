package com.gtmarttiles.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class TestStoredFunction {

    /*
     create or replace function getAvgPrize(designNo1 IN STRING, designNo2 IN STRING)  return float
     AS 
     prize1 number;
     prize2 number;
     BEGIN
     select prize into prize1 from tiles where design_no=designNo1; 
     select prize into prize2 from tiles where design_no=designNo2;
     return (prize1+prize2)/2;
     END getAvgPrize;
     /
     */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","system");
        CallableStatement cst=con.prepareCall("{? = call getAvgPrize(?,?)}");
        cst.setString(2, "100");
        cst.setString(3, "656");
        cst.registerOutParameter(1, Types.FLOAT);
        cst.execute();
        System.out.println("AVG prize :"+cst.getFloat(1));
        cst.close();
        con.close();
	}

}
