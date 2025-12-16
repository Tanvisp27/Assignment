package com.internship.quiz.menu;

import java.util.Scanner;

public class MainMenu {
	private static int MainMenuOptions(Scanner sc) {
		System.out.println("----------MainMenu----------");
		System.out.println("1. Admin Login");
		System.out.println("2. Student Registretion");
		System.out.println("3. Student login Login");
		System.out.println("4. Exit");
		
		return sc.nextInt();
	}
	
	public static void MainMenu(Scanner sc){
		int choice;
		while((choice=MainMenuOptions(sc))!=4) {
			switch(choice) {
			case 1:
				System.out.println("You have selected Admin Login case"); 
				AdminMenu.adminMenu(sc);
				
				break;
				
			case 2:
				System.out.println("You have selected Student Registration case");
				
				break;
				
			case 3:
				System.out.println("You have selected Student Login case");
				StudentMenu.studentMenu(sc);
				
				break;
				
			default:
				System.out.println("Wrong Choice");
				
				break;	
				
			}
		}	
	}
}
