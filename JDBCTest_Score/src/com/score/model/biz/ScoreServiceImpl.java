package com.score.model.biz;

import java.util.List;

import com.score.model.dao.ScoreDaoImpl;
import com.score.model.dto.Score;

public class ScoreServiceImpl implements ScoreService{

	ScoreDaoImpl dao = new ScoreDaoImpl();
	
	@Override
	public List<Score> getAll() {
		// TODO Auto-generated method stub
		return null;
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
