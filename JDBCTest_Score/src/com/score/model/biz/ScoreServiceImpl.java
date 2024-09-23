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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Score s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Score s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
