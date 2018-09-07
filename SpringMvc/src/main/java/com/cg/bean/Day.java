package com.cg.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Day {

	
	private String name;
	@OneToMany(cascade=javax.persistence.CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Game> game;
	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Game> getGame() {
		return game;
	}
	public void setGame(List<Game> game) {
		this.game = game;
	}
	/*@Override
	public String toString() {
		return "Day [name=" + name + ", game=" + game + ", id=" + id + "]";
	}*/
	/*@Override
	public String toString() {
		return "Day =" + name + ", " + game + " ";
	}*/
	
	

}
