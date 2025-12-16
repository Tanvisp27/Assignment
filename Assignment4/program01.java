package com.classwork.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class program01 {
	
	private static final String URL = "jdbc:mysql://localhost:3306/classwork";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL , USERNAME , PASSWORD);
		
	}
	
	//select
	public static void getAllStudents() {
		//String sql = "select rollno , name , email , course from students";
		String sql = "select * from students";
		
		try {
			Connection connection = getConnection();
			PreparedStatement selectStatement = connection.prepareStatement(sql);
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				//String course = rs.getString(4);
				String course = rs.getString(5);
				System.out.println(rollno + "-" + name + "-" + email + "-" + course);
				
			}
			
			connection.close();
			selectStatement.close();
			
		} catch(SQLException e){
			e.printStackTrace();
		}

	}
	
	//insert
	public static void addStudents(String name , String email , String course) {
	
		String sql = "insert into students(name , email , course) values(?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, email);
			insertStatement.setString(3, course);
			insertStatement.executeUpdate();
			connection.close();
			insertStatement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//update
	public static void updateStudents(String course , int rollno) {
		
		String sql ="update students set course=? where rollno = ?";
		
		try {
			Connection connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(sql);
			updateStatement.setString(1, course);
			updateStatement.setInt(2, rollno);
			updateStatement.executeUpdate();
			
			connection.close();
			updateStatement.close();
			System.out.println("Updated successfully!!!!!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//delete
	public static void deleteStudents(int rollno) {
		
		String sql ="delete from students where rollno=?";
		
		try {
			Connection connection=getConnection();
			PreparedStatement deleteStatement = connection.prepareStatement(sql);
			deleteStatement.setInt(1,rollno);
			deleteStatement.executeUpdate();
			
			connection.close();
			deleteStatement.close();
			
			System.out.println("Deleted Successfully !!!!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int Menu(Scanner sc)
	{
		System.out.println("----------Menu are----------");
		System.out.println("0. Exit");
		System.out.println("1. Display All Students");
		System.out.println("2. Insert Student");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		
		System.out.println("Which Operation do you want to perform ? :");
		return sc.nextInt();
		
	}


	public static void main(String[] args) {
		int rollno;
		String course , email , name ;
		Scanner sc =new Scanner(System.in);
		
		int choice;
		while((choice=Menu(sc))!= 0)
		{
			switch(choice) {
			case 1:
				getAllStudents();
				break;
			
			case 2:
				System.out.println("Enter Name :");
				name=sc.next();
				
				System.out.println("Enter Email of the Student :");
				email=sc.next();
				
				System.out.println("Enter Course of the Student :");
				course=sc.next();
				
				addStudents(name , email , course);
				
				break;
				
			case 3:
				System.out.println("Enter Roll Number of the Student you want to update :");
				rollno=sc.nextInt();
				
				System.out.println("Enter New Course you Want to Update :");
				course =sc.next();
				
				updateStudents(course , rollno);
				break;
			case 4:
				System.out.println("Enter roll number which you want to delete :");
				rollno=sc.nextInt();
				deleteStudents(rollno);
				
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
