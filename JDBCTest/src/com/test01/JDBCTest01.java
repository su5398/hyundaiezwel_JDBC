package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. 준비(DriverManager, Connection)
		//jdbc 연결을 위해서는 ojdbc 추가가 필수!
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//getConnection(url, username, password)
		String url = "jdbc:oracle:thin:@multi0729_high?TNS_ADMIN=C:\\\\DataBaseTest\\\\Wallet_Multi0729";
		
		String username = "MULTI";
		String password = "Test09061234";
		
		Connection con = DriverManager.getConnection(url,username,password);
										
		//2. 실행(Statement, execute())
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(" SELECT * FROM EMPLOYEE ");
		
		//3. 결과처리
		//next() : 커서를 다음 row로 이동 시킨 후 데이터가 있는지 없는지 판단(있으면 true, 없으면 false)
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt("SALARY"));
								// getXxxx() : 현재 커서가 가르키는 row의 특정 컬럼값을 가지고 오겠다.
 		}
		//4. 종료
		rs.close();
		stmt.close();
		con.close();
	}

}
