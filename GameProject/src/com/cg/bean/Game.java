package com.cg.bean;

public class Game {
 private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Game [name=" + name + "]";
}
}
