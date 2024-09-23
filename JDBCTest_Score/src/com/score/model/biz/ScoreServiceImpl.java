package com.score.model.biz;

import java.sql.Connection;
import java.util.List;

import com.score.model.dao.ScoreDaoImpl;
import com.score.model.dto.Score;
import static common.JDBCTemplate.*;


public class ScoreServiceImpl implements ScoreService{

	ScoreDaoImpl dao = new ScoreDaoImpl();
	
	@Override
	public List<Score> getAll() {
		
		Connection con = getConnection();
		List<Score> res = dao.getAll(con);
		Close(con);
		return res;
		
	}

	@Override
	public Score getOne(String name) {
		Connection con = getConnection();
		Score res = dao.getOne(con, name);
		Close(con);
		
		return res;
	}

	@Override
	public int insert(Score s) {
		Connection con = getConnection();
		
		int res = dao.insert(con, s);
		
		if(res>0) {
			Commit(con);
		}else {
			Rollback(con);
		}
		
		Close(con);
		
		return res;
	}

	@Override
	public int update(Score s) {
		Connection con = getConnection();
		
		int res = dao.update(con, s);
		
		if(res>0) {
			Commit(con);
		}else {
			Rollback(con);
		}
		
		Close(con);
		
		return res;
	}

	@Override
	public int delete(String name) {
		Connection con = getConnection();
		
		int res = dao.delete(con, name);
		
		if(res>0) {
			Commit(con);
		}
		Close(con);
		
		return res;
	}

}
