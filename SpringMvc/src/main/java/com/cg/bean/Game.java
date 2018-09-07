
package com.cg.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@NamedQuery(name=Game.FIND_ALL, query="SELECT g FROM Game g")
@Entity
public class Game {
	@Id
	@GeneratedValue
	private int id;
	private String name;
  


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Game: name=" + name + " ";
	}

	}


