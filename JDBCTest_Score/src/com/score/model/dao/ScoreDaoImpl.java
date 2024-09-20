package com.score.model.dao;

import java.sql.Connection;
import java.util.List;

import com.score.model.dto.Score;

public class ScoreDaoImpl implements ScoreDao {

	@Override
	public List<Score> getAll(Connection con) {
		return null;
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
