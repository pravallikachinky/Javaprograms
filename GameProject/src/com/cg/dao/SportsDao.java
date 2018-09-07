package com.cg.dao;

import java.util.List;

import com.cg.bean.Day;

public interface SportsDao {
 public Day save(Day d); 
 public Day findByDayName(String name);
 public List<Day> findByGameName(String name);
}
