package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.bean.Day;


public class SportsRepoImpl {
	private EntityManager em;
	public SportsRepoImpl(EntityManager em)
	{
		super();
		this.em=em;
	}
	public Day save(Day day) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(day);
		em.getTransaction().commit();
		
		return day;

	
	}

	public Day findByDayName(String name) {
		// TODO Auto-generated method stub
		/*if (data.containsKey(name)) {
			return data.get(name);
		} else {
			return null;
		}*/
		TypedQuery<Day> query=em.createQuery("select d from Day d where d.name=:name",Day.class );
		query.setParameter("name",name);
		Day day=query.getSingleResult();
		return day;
		
	
	}

	public List<Day> findByGameName(String name) {
		// TODO Auto-generated method stub
		/*List<Day> dayList = new ArrayList<Day>();
		for (Day day : data.values()) {
			List<Game> list = day.getGame();
			for (Game game : list) {
				System.out.println(game);
				System.out.println();
				if(game.getName().equals(name)){
					dayList.add(day);
				}
			}
		}*/
		em.getTransaction().begin();
		TypedQuery<Day> query=em.createQuery("select d from Day d Inner join d.game g where g.name=:g",Day.class);
		query.setParameter("g", name);
		em.getTransaction().commit();
		return query.getResultList();

	}

}
