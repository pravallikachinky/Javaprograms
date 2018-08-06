package com.cg.plp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;
import com.cg.plp.util.EMUtil;

public class AccountDao implements IAccountDao {
//HashMap<String, Account> accMap=AccountDB.getacc();
	
	@Override
	public String createAcc(Account account) throws AccountException {
		EntityManager em = EMUtil.getEntityManager();

		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();

		em.close();

		return account.getPhoneNum();
	
	}
	@Override
	public double showBal(String phoneNum) throws AccountException {
		Account acc = getDetails(phoneNum);
		return acc.getBal();
	}
	@Override
	public Double deposit(String phoneNum, double amount) throws AccountException {
		Account account = getDetails(phoneNum);
		double newBal = account.getBal() + amount;

		account.setBal(newBal);
		account.setDoj(Date.valueOf(LocalDate.now()));

		EntityManager em = EMUtil.getEntityManager();

		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();

		em.close();
		
		return account.getBal();
	}
	
	@Override
	public double withdraw(String phoneNum, double amount)
			throws AccountException {
		Account account = getDetails(phoneNum);
		double newBal = account.getBal() - amount;

		account.setBal(newBal);
		account.setDoj(Date.valueOf(LocalDate.now()));

		EntityManager em = EMUtil.getEntityManager();

		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();

		em.close();
		return account.getBal();
	}
	@Override
	public boolean fundTransfer(String phoneNum1, String phoneNum2,
			double amount) throws AccountException {
		withdraw(phoneNum1, amount);
		deposit(phoneNum2, amount);

		return true;
	}

	
	@Override
	public Account getDetails(String phoneNum) throws AccountException {
		EntityManager em = EMUtil.getEntityManager();
		Account acc = null;
		try {
			TypedQuery<Account> accQuery = em.createQuery("SELECT a FROM Account a WHERE PHONENUM=?", Account.class);
			accQuery.setParameter(1, phoneNum);

			acc = accQuery.getSingleResult();
			em.close();
		} catch (NoResultException e) {
			// TODO: handle exception
			throw new AccountException("Account does not exist");
		}
		return acc;
        
	}
	


}
