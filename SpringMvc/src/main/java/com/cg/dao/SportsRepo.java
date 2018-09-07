package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.bean.Day;

public interface SportsRepo extends JpaRepository<Day,Integer> {
	/*Day save(Day day);
	Day (findByDayNameString name);
	List<Day> findByGameName(String name);*/
	
	
	@Query(value="select d from Day d where d.name=(:name)")
	Day findByDayName(@Param(value="name")String name);
	@Query(value="select d from Day d Inner join d.game g where g.name=:name")
	List<Day> findByGameName(@Param(value="name")String name);

}
	
	

