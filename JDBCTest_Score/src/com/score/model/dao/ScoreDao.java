package com.score.model.dao;

import java.sql.Connection;
import java.util.List;

import com.score.model.dto.Score;

public interface ScoreDao {
	
	String getAllSql = " SELECT * FROM SCORE ";
	String getOneSql = " SELECT * FROM SCORE WHERE NAME=? ";
	String insertSql = " INSERT INTO SCORE VALUES(?,?,?,?,?,?,?)";
	String updateSql = " UPDATE SCORE SET KOR=?,ENG=?,MATH=?,SUM=?,AVG=?,GRADE=? WHERE NAME=? ";
	String deleteSql = " DELETE FROM SCORE WHERE NAME=? ";
	 
	public List<Score> getAll(Connection con);
	public Score getOne(Connection con, String name);
	public int insert(Connection con, Score s);
	public int update(Connection con, Score s);
	public int delete(Connection con, String name);
}
