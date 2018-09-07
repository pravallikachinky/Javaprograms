package com.cg.service;

import java.util.List;

import com.cg.bean.Day;

public interface SportsService {
	Day addDay(Day day);
	Day findByDayName(String name);
	List<Day> findByGameName(String name);
	

}
