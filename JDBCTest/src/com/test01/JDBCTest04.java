package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class JDBCTest04 {

	public static void main(String[] args) throws SQLException {
		//준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		int no=0;
		String name=null;
		String nickName=null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호입력: ");
		no = sc.nextInt();
		System.out.print("이름입력: ");
		name=sc.next();
		System.out.print("별명입력: ");
		nickName=sc.next();
		
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";
		
		con = getConnection();
		pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, no);
		pstm.setString(2, name);
		pstm.setString(3, nickName);
		
		int res = pstm.executeUpdate();
		if(res>0) {
			System.out.println("insert 성공");
			Commit(con);
		}else {
			System.out.println("insert 실패");
			Rollback(con);
		}
		
		Close(pstm);
		Close(con);
		sc.close();
	}

}
