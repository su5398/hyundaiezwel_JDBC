package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class JDBCTest05 {

	public static void main(String[] args) throws SQLException {
		//update 구현, JDBCTemplate사용하지 않고.
		String sql = " UPDATE MYTEST SET MNAME=?, NICKNAME=? WHERE MNO=? ";
		
		//준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		int no = 0;
		String name = null;
		String nickName = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 번호 입력: ");
		no = sc.nextInt();
		System.out.print("수정할 이름: ");
		name = sc.next();
		System.out.print("수정할 별명: ");
		nickName = sc.next();
		
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, nickName);
		pstm.setInt(3, no);
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("update 성공");
			con.commit();
		}else {
			System.out.println("update 실패");
			con.rollback();
		}
		
		Close(pstm);
		Close(con);
		sc.close();
		
	}

}
