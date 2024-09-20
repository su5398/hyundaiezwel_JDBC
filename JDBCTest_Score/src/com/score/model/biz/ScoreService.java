package com.score.model.biz;

import java.util.List;

import com.score.model.dto.Score;

public interface ScoreService {
	public List<Score> getAll();
	public Score getOne(String name);
	public int insert(Score s);
	public int update(Score s);
	public int delete(String name);
}
