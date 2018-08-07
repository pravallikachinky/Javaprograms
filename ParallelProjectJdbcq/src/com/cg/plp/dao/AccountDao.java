package com.cg.plp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;




import com.cg.plp.bean.Account1;
import com.cg.plp.exception.AccountException;
import com.cg.plp.util.Dutil;

public class AccountDao implements IAccountDao {
//HashMap<String, Account> accMap=AccountDB.getacc();
	
	@Override
	public String createAcc(Account1 account) throws AccountException {
		Connection con=Dutil.getConnection();
		String n="";
		try {
			PreparedStatement stat=con.prepareStatement("INSERT INTO ACCOUNT1 VALUES(?,?,?,?,?,?)");
			stat.setString(1,account.getPhoneNum());
			stat.setString(2, account.getCustName());
			stat.setString(3, account.getGender());
			stat.setDouble(4, account.getBal());
			stat.setString(5, account.getEmailId());
			stat.setDate(6, account.getDoj());
			int rs=stat.executeUpdate();
			
			if(rs==1){
				Statement st=con.createStatement();
				ResultSet res=stat.executeQuery();
				if(res!=null)
					res.next();
				 n=account.getPhoneNum();
				
				return n;
				
			}else{
				throw new AccountException("Account is not created in dbms");
			}
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		
		
	
	
	
	}
	@Override
	public double showBal(String phoneNum) throws AccountException {
		Connection con=Dutil.getConnection();
		Double money=0.00;
		
		try {
			PreparedStatement ps=con.prepareStatement("SELECT bal FROM ACCOUNT1 WHERE phoneNum=?");
			ps.setString(1,phoneNum );
			ResultSet res=ps.executeQuery();
			if(res!=null){
				res.next();
			money=res.getDouble("bal");
			}
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		return money;
	}
	@Override
	public Double deposit(String phoneNum, double amount)
			throws AccountException {
		Connection con=Dutil.getConnection();
		Account1 acc=new Account1(); 
		double dep;
		
		try {
			PreparedStatement ps1=con.prepareStatement("SELECT * FROM ACCOUNT1 WHERE phoneNum=?");
	        ps1.setString(1, phoneNum);	
	        ResultSet res=ps1.executeQuery();
	        if(res!=null){
				res.next();
            dep=res.getDouble(4)+amount;
            acc.setBal(dep);
			PreparedStatement ps=con.prepareStatement("UPDATE Account1 SET bal=? WHERE phoneNum=?");
			ps.setDouble(1, acc.getBal());
			ps.setString(2, phoneNum);
			int res1=ps.executeUpdate();
	        }else
				throw new AccountException("Account does not exists");
			return dep;
	        
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
	}
	
	@Override
	public double withdraw(String phoneNum, double amount)
			throws AccountException {
		Account1 acc = getDetails(phoneNum);
		double finalBal = acc.getBal() - amount; 
		acc.setBal(finalBal);
		acc.setDoj(Date.valueOf(LocalDate.now()));
		
		Connection connection = Dutil.getConnection();
		try {
			PreparedStatement stat = connection.prepareStatement("UPDATE ACCOUNT1 SET BAL=?, DOJ = ? WHERE PHONENUM=?");
			stat.setDouble(1, acc.getBal());
			stat.setDate(2, acc.getDoj());
			stat.setString(3, phoneNum);
			int res = stat.executeUpdate();
			 return acc.getBal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}
	@Override
	public boolean fundTransfer(String phoneNum1, String phoneNum2,
			double amount) throws AccountException {
		/*Account1 acc1 = getDetails(phoneNum1);
		Account1 acc2 = getDetails(phoneNum2);
		
		if(acc1 == null || acc2 == null)
			throw new AccountException("Account doesnot exist. Amount can't be transferred");
		
		if(amount > acc1.getBal())
			throw new AccountException("Account balance is low");
		double bal = acc1.getBal()-amount;			
		acc1.setBal(bal);
		double bal1 = acc2.getBal()+amount;
		acc2.setBal(bal1);		
		
		Connection connection = Dutil.getConnection();
		try {
			PreparedStatement stat = connection.prepareStatement("UPDATE ACCOUNT1 SET bal=?, doj= ? WHERE phoneNum=?");
			stat.setDouble(1, acc1.getBal());
			stat.setDate(2, acc1.getDoj());
			stat.setString(3, phoneNum1);
			int res1 = stat.executeUpdate();
			
			PreparedStatement stat1 = connection.prepareStatement("UPDATE ACCOUNT1 SET bal=?, doj= ? WHERE phoneNum=?");
			stat.setDouble(1, acc2.getBal());
			stat.setDate(2, acc2.getDoj());
			stat.setString(3, phoneNum2);
			int res2 = stat1.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
*/	withdraw(phoneNum1, amount);
	deposit(phoneNum2, amount);
		
		return true;
	}

	
	@Override
	public Account1 getDetails(String phoneNum) throws AccountException {
		Connection con=Dutil.getConnection();
		PreparedStatement ps1;
		Account1 acc=null;
		try {
			ps1 = con.prepareStatement("SELECT * FROM ACCOUNT1 WHERE phoneNum=?");
			ps1.setString(1, phoneNum);	
	        ResultSet res=ps1.executeQuery();
	        while(res.next()){
				//System.out.println("Val: "+resultSet.getString(3));
				if(res.getString(1).equals(phoneNum)){
					acc = new Account1();
					acc.setPhoneNum(res.getString(1));
					acc.setCustName(res.getString(2));
					acc.setGender(res.getString(3));
					acc.setEmailId(res.getString(5));
					acc.setBal(res.getDouble(4));
					acc.setDoj(res.getDate(6));
					
					return acc;
				}
			}
			throw new AccountException("Account Does not exist");
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
        
	}
	


}
