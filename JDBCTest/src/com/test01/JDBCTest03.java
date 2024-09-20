package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.JDBCTemplate;

public class JDBCTest03 {

	public static void main(String[] args) throws SQLException {
		//INSERT 실행
		
		//준비
		Connection con = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		int no=0;
		String name=null;
		String nickName =null;
		
		System.out.print("번호입력: ");
		no = sc.nextInt();
		System.out.print("이름입력: ");
		name = sc.next();
		System.out.print("별명입력: ");
		nickName = sc.next();

		//"INSERT INTO MYTEST VALUES(no, 'name','nickname')"
		String sql = "INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickName+"')";
		
		
		//실행 및 결과 리턴
		con = JDBCTemplate.getConnection();
		stmt = con.createStatement();
		
		int res = stmt.executeUpdate(sql);
		
		if(res>0) {
			System.out.println("insert 성공");
			JDBCTemplate.Commit(con);
		}else {
			System.out.println("insert 실패");
		}
		
		//JDBCTemplate.Close(stmt);
		//JDBCTemplate.Close(con);
		//sc.close();
		
	}

}
