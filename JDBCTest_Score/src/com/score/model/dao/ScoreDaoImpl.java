package com.score.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.score.model.dto.Score;
import static common.JDBCTemplate.*;

public class ScoreDaoImpl implements ScoreDao {

	@Override
	public List<Score> getAll(Connection con) {
		//준비
		Statement stmt = null;
		ResultSet rs = null;
		List<Score> res = new ArrayList<Score>();
		
		
		try {
			//실행
			stmt = con.createStatement();
			rs = stmt.executeQuery(getAllSql);
			
			//결과
			while(rs.next()) {
				Score tmp = new Score();
				tmp.setName(rs.getString(1));
				tmp.setKor(rs.getInt(2));
				tmp.setEng(rs.getInt(3));
				tmp.setMath(rs.getInt(4));
				tmp.setSum(rs.getInt(5));
				tmp.setAvg(rs.getInt(6));
				tmp.setGrade(rs.getString(7));
				
				res.add(tmp);
			}
			
		} catch (SQLException e) {
			System.out.println("[Error]get all 실패");
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(stmt);
		}
		return res;
	}

	@Override
	public Score getOne(Connection con, String name) {
		return null;
	}

	@Override
	public int insert(Connection con, Score s) {
		return 0;
	}

	@Override
	public int update(Connection con, Score s) {
		return 0;
	}

	@Override
	public int delete(Connection con, String name) {
		return 0;
	}
	
}
