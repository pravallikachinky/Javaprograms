package com.cg.plp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.plp.exception.AccountException;

public class EMUtil {
	public static EntityManager getEntityManager() throws AccountException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		return emf.createEntityManager();
		
	}
}