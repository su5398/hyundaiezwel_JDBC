package com.score.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Score res = null;
		
		try {
			pstm = con.prepareStatement(getOneSql);
			pstm.setString(1, name);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				res = new Score(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getDouble(6),rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(pstm);
		}
		return res;
	}

	@Override
	public int insert(Connection con, Score s) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(insertSql);
			pstm.setString(1, s.getName());
			pstm.setInt(2, s.getKor());
			pstm.setInt(3, s.getEng());
			pstm.setInt(4, s.getMath());
			pstm.setInt(5, s.getSum());
			pstm.setDouble(6, s.getAvg());
			pstm.setString(7, s.getGrade());
			
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(pstm);
		}
		
		return res;
	}

	@Override
	public int update(Connection con, Score s) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(updateSql);
			pstm.setInt(1, s.getKor());
			pstm.setInt(2, s.getEng());
			pstm.setInt(3, s.getMath());
			pstm.setInt(4, s.getSum());
			pstm.setDouble(5, s.getAvg());
			pstm.setString(6, s.getGrade());
			pstm.setString(7, s.getName());
			
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(pstm);
		}
		
		return res;
	}

	@Override
	public int delete(Connection con, String name) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(deleteSql);
			pstm.setString(1, name);
			
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(pstm);
		}
		
		return res;
	}
	
	
	
}
