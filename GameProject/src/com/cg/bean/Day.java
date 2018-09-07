package com.cg.bean;

import java.util.List;

public class Day {
	 private String Name;
	 private List<Game> games;
	public String getName() {
		return Name;
	}
	public void setdName(String dName) {
		this.Name = dName;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public Day(String dName, List<Game> games) {
		super();
		this.Name = dName;
		this.games = games;
	}
	@Override
	public String toString() {
		return "Day [dName=" + Name + ", games=" + games + "]";
	}

}
