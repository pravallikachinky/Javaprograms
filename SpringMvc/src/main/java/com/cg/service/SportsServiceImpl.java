package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.bean.Day;
import com.cg.dao.SportsRepo;

@Service(value="service")
public class SportsServiceImpl implements SportsService {
	private SportsRepo repo;
	public SportsServiceImpl(SportsRepo repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	@Transactional
	public Day addDay(Day day) {
		// TODO Auto-generated method stub
		
		return repo.save(day);
	}
	public Day save(Day day) {
		// TODO Auto-generated method stub
		return null;
	}
	public Day findByDayName(String name) {
		// TODO Auto-generated method stub
		return repo.findByDayName(name);
	}
	public List<Day> findByGameName(String name) {
		// TODO Auto-generated method stub
		return repo.findByGameName(name);
	}
	
	

}
