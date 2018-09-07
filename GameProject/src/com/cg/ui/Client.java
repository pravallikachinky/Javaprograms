package com.cg.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.dao.SportsDao;
import com.cg.dao.SportsDaoImpl;
import com.cg.service.SportsService;
import com.cg.service.SportsServiceImpl;

public class Client {

	static Scanner scan = new Scanner(System.in);
	 Map<String,Day> map=new HashMap<String,Day>();
	 SportsDao repo = new SportsDaoImpl(map);
    SportsService service=new SportsServiceImpl(repo);
	public static void main(String[] args) {
		String optn = "";
		Client c = new Client();
		while (true) {

			System.out.println("1.Save the information");
			System.out.println("2.Retrieve the information about a day");
			System.out.println("3.Retrieve the information about a game");
			System.out.println("4.exit");
			System.out.println("Enter the option");
			optn = scan.nextLine();

			switch (optn) {
			case "1":
					c.saveDay();
				break;

			case "2":
						c.retriveByDay();
				break;
			case "3":
						c.retriveByGame();
				break;
			case "4":
				System.exit(0);
			

				break;

			default:
				System.out.println("Enter the value from 1 to 4");
				break;
			}
		}
	}

	private void saveDay() {
		List<Game> l1 = new ArrayList<Game>();
		Game g11 = new Game();
		g11.setName("Cricket");
		Game g12 = new Game();
		g12.setName("Football");
		Game g13 = new Game();
		g13.setName("Hockey");
		Game g14 = new Game();
		g14.setName("Tennis");

		l1.add(g11);
		l1.add(g12);
		l1.add(g13);
		l1.add(g14);

		Day d1 = new Day("day1", l1);
		System.out.println("the day is added" +service.save(d1).getName());

//**************************************
		List<Game> l2 = new ArrayList<Game>();
		Game g21 = new Game();
		g21.setName("Runnng");
		Game g22 = new Game();
		g22.setName("Boxing");
		Game g23 = new Game();
		g23.setName("Cricket");

		l2.add(g21);
		l2.add(g22);
		l2.add(g23);

		Day d2 = new Day("day2", l2);
		System.out.println("the day is added" +service.save(d2).getName());
		// ***********************************
		List<Game> l3 = new ArrayList<Game>();
		Game g31 = new Game();
		g31.setName("Tennis");
		Game g32 = new Game();
		g32.setName("Weighing");
		Game g33 = new Game();
		g33.setName("kho-kho");
		Game g34 = new Game();
		g34.setName("Wrestling");

		l3.add(g31);
		l3.add(g32);
		l3.add(g33);
		l3.add(g34);

		Day d3 = new Day("day3", l3);
		System.out.println("the day is added" +service.save(d3).getName());
		// *******************************
		List<Game> l4 = new ArrayList<Game>();
		Game g41 = new Game();
		g41.setName("Football");
		Game g42 = new Game();
		g42.setName("Weighing");

		l4.add(g41);
		l4.add(g42);

		Day d4 = new Day("day4", l4);
		System.out.println("the day is added" +service.save(d4).getName());
		// *******************************
		List<Game> l5 = new ArrayList<Game>();
		Game g51 = new Game();
		g31.setName("Carroms");
		Game g52 = new Game();
		g32.setName("Weighing");
		Game g53 = new Game();
		g33.setName("Boxing");
		Game g54 = new Game();
		g34.setName("Wrestling");

		l5.add(g51);
		l5.add(g52);
		l5.add(g53);
		l5.add(g54);

		Day d5 = new Day("day5", l5);
		System.out.println("the day is added" +service.save(d5).getName());
	}
	private void retriveByDay() {

		String dayName = "";
		System.out.println("Enter Day:");
		dayName = scan.nextLine();
		Day day = service.findByDayName(dayName);
		System.out.println(day.getGames());

	}

	private void retriveByGame() {

		String gameName = "";
		System.out.println("Enter Game:");
		gameName = scan.nextLine();
		List<Day> dayList = service.findByGameName(gameName);

		for (Day day : dayList) {
			System.out.println(day.getName());
		}
	}
}
