package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.bean.Day;
import com.cg.bean.Game;

public class SportsDaoImpl implements SportsDao {
	private Map<String,Day> map;
	
	public SportsDaoImpl(Map<String, Day> map) {
		super();
		this.map = map;
	}
	@Override
	public Day save(Day d) {
		map.put(d.getName(), d);
		return d;
	}
	@Override
	public Day findByDayName(String name) {
		if(map.containsKey(name)) {
			return map.get(name);
		}else {
			return null;
		}
	}
	@Override
	public List<Day> findByGameName(String name) {

		List<Day> dayList = new ArrayList<Day>();
		for (Day day : map.values()) {
			List<Game> list = day.getGames();
			for (Game game : list) {
				/*System.out.println(game);
				System.out.println();*/
				if(game.getName().equals(name)){
					dayList.add(day);
				}
			}
		}
		return dayList;
	}
	
	

}
