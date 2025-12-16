package com.internship.quiz.menu;

import java.util.Scanner;

public class AdminMenu {
	private static int AdminMenuOptions(Scanner sc) {
		System.out.println("----------AdminMenu----------");
		System.out.println("0.Logout");
		System.out.println("1.Create Quizzes");
		System.out.println("2.List Quizzes");
		return sc.nextInt();
	}
	
	public static void adminMenu(Scanner sc) {
		int choice;
		while((choice = AdminMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("You have Selected Create Quize case");
				break;
				
			case 2:
				System.out.println("You have Selected List Quize case");
				
				break;
				
			default:
				System.out.println("Wrong Choice");
				break;
			
			}
			
		}
		
	}

}
