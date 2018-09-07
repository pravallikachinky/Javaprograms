package com.cg.service;

import java.util.List;

import com.cg.bean.Day;
import com.cg.dao.SportsDao;

public class SportsServiceImpl implements SportsService {

	private SportsDao repo;
	
	public SportsServiceImpl(SportsDao repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	@Override
	public Day save(Day d) {
	
		return repo.save(d);
	}

	@Override
	public Day findByDayName(String name) {
		return repo.findByDayName(name);
	}

	@Override
	public List<Day> findByGameName(String name) {
		return repo.findByGameName(name);
	}

}
