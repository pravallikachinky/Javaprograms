package com.cg.service;

import java.util.List;

import com.cg.bean.Day;

public interface SportsService {
	public Day save(Day d); 
	public Day findByDayName(String name);
	 public List<Day> findByGameName(String name);
}
