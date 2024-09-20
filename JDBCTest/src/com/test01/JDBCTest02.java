package com.test01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//3. 3번째 방식
import static common.JDBCTemplate.*;

public class JDBCTest02 /* 2. 2번째 방식 extends JDBCTemplate*/{

	public static void main(String[] args) throws SQLException {
		
		//1. 첫번째 방식
		//Connection con = JDBCTemplate.getConnection();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * FROM DEPARTMENT");
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+" : "+rs.getString(2)+" - "+rs.getString("LOCATION_ID"));
		}
		Close(rs);
		Close(stmt);
		Close(con);
	}

}
