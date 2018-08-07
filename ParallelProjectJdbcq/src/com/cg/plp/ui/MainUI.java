package com.cg.plp.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.cg.plp.bean.Account1;
import com.cg.plp.exception.AccountException;
import com.cg.plp.service.AccountService;
import com.cg.plp.service.IAccountService;

public class MainUI {
	Scanner sc = new Scanner(System.in);
	IAccountService serv = new AccountService();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MainUI ui = new MainUI();
		String opt = "";

		while (true) {
			System.out.println("1. Create Account\n2. Show balance\n3. Deposit amount\n"
					+ "4. Withdraw amount\n5. Transfer\n6. Transaction\n7. Exit");
			System.out.println("Enter choice:");
			opt = sc.nextLine();
			switch (opt) {
			case "1":
				ui.accountCreation();
				break;
			case "2":
				ui.showBalance();
				break;
			case "3":
				ui.depositAmount();
				break;
			case "4":
				ui.withdrawAmount();
				break;
			case "5":
				ui.fundTransfer();
				break;
			case "6":
				ui.printTransaction();
				break;
			case "7":
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter Correct option");
				break;
			}
		}
	}

	private void accountCreation() {
		Account1 a = new Account1();
		MainUI ui = new MainUI();
		System.out.println("Enter Mobile Number:");
		a.setPhoneNum(ui.sc.nextLine());
		System.out.println("Enter Name:");
		a.setCustName(ui.sc.nextLine());
		System.out.println("Enter the gender");
		a.setGender(ui.sc.nextLine());
		System.out.println("Enter current balance:");
		a.setBal(Double.parseDouble(ui.sc.nextLine()));
	
		System.out.println("Enter Email ID:");
		a.setEmailId(ui.sc.nextLine());
			a.setDoj(Date.valueOf(LocalDate.now()));

		try {
			String id = serv.createAcc(a);
			System.out.println(id + " has been added successfully");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}

	private void showBalance() {
		System.out.println("Enter mobile number:");
		String mobile = sc.nextLine();

		try {
			double bal = serv.showBal(mobile);
			System.out.println("Current balance:" + bal);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}
	}

	private void depositAmount() {
		// TODO Auto-generated method stub
		System.out.println("Enter mobile number");
		String mobile = sc.nextLine();
		try {
			if (serv.validateMobile(mobile)) {
				// Account a = serv.getAccountDetails(mobile);
				System.out.println("Enter amount to be deposited:");
				double amt = Double.parseDouble(sc.nextLine());
				double finalAmt = serv.deposit(mobile, amt);
				System.out.println("Account with mobile id:" + mobile + " has been deposited with " + amt);
				System.out.println("Current Balance in the account:" + finalAmt);
			}

		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}

	private void withdrawAmount() {
		// TODO Auto-generated method stub
		System.out.println("Enter mobile number");
		String mobile = sc.nextLine();
		try {
			if (serv.validateMobile(mobile)) {
				// Account a = serv.getAccountDetails(mobile);
				System.out.println("Enter amount to be withdrawn:");
				double amt = Double.parseDouble(sc.nextLine());
				double finalAmt = serv.withdraw(mobile, amt);
				System.out.println("Account with mobile id:" + mobile + " has been withdrawn with " + amt);
				System.out.println("Current Balance in the account:" + finalAmt);
			}

		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}

	private void fundTransfer() {
		// TODO Auto-generated method stub
		System.out.println("Enter your mobile no:");
		String m1 = sc.nextLine();
		System.out.println("Enter receivers mobile number:");
		String m2 = sc.nextLine();
		System.out.println("Enter Transfer Amount:");
		double amount = Double.parseDouble(sc.nextLine());
		try {
			boolean res = serv.fundTransfer(m1, m2, amount);
			if (res)
				System.out.println("Fund Transferred");

		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}

	private void printTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Enter Mobile number");
		String mobile = sc.nextLine();
		try {
			System.out.println(serv.getDetails(mobile));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}
}
