package com.StudentGradeManagementSystem;

import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		run();
	

	}

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to add Student");
		System.out.println("Enter 2 to update Student");
		System.out.println("Enter 3 to delete Student");
		int choose=sc.nextInt();
		switch(choose) {
		case 1:
			Student.addStudent();
			break;
		case 2:
			Student.updateStudent();
			break;
		case 3:
			Student.deleteStudentData();
			break;
		}
		
			
	}

}
