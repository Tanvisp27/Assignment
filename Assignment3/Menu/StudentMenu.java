package com.internship.quiz.menu;

import java.util.Scanner;

public class StudentMenu {
	private static int StudentMenuOption(Scanner sc) {
		System.out.println("----------StudentMenu----------");
		System.out.println("0.Logout");
		System.out.println("1.View Quizes");
		System.out.println("2.Take Quize");
		System.out.println("3.View Score");

		return sc.nextInt();
	}
	
	public static void studentMenu(Scanner sc) {
		int choice;
		while((choice = StudentMenuOption(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("You have Selected View Quize case");
				break;
				
			case 2:
				System.out.println("You have Selected Take Quize case");
				
				break;
				
			case 3:
				System.out.println("You have Selected View Score case");
				
				break;
				
				
			default:
				System.out.println("Wrong Choice");
				break;
			
			}
		}	
	}
}
