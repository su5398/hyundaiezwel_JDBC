package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class JDBCTest06 {

	public static void main(String[] args) throws SQLException {
		//DELETE(이름 입력받아 삭제)
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		String name = null;
		String sql = " DELETE FROM MYTEST WHERE MNAME = ? ";
		
		System.out.print("삭제할 이름: ");
		name = new Scanner(System.in).next();
		
		con = getConnection();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("delete 성공");
			con.commit();
		}else {
			System.out.println("delelte 실패");
			con.rollback();
		}
		
		Close(pstm);
		Close(con);
		
		select();
		
	}
	
	public static void select() throws SQLException {
		// mytest 테이블 전체조회
		
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(" SELECT * FROM MYTEST ");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString("MNAME")+" "+ rs.getString(3));
		}
		Close(rs);
		Close(stmt);
		Close(con);
		
	}

}
