package com.gtmarttiles.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/*
create or replace procedure getPrize(designNo IN STRING, tilesprize OUT number)
AS
BEGIN
select prize into tilesprize from tiles where design_no=designNo;
END getPrize;
/

 */

public class TestStoredProcedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","system");
        CallableStatement cst=con.prepareCall("{call getPrize(?,?)}");
        cst.setString(1, "100");
        cst.registerOutParameter(2, Types.INTEGER);
        cst.execute();
        System.out.println("prize :"+cst.getInt(2));
        cst.close();
        con.close();
	}
}
