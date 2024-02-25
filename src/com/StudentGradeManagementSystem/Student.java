package com.StudentGradeManagementSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Student {
	 String name;
	 int rollNumber;
	 Map<String,Integer> studentMarks;
	  static Map<Integer, Student> studentMap;
	 
	Student(String name, int rollNumber){
		this.name=name;
		this.rollNumber=rollNumber;
		this.studentMarks=new HashMap<>();
	}
	
/*This addStudent method will take inputs from the console with the help of Scanner class
 * and loads the data into the HashMap  */
	public static void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name=sc.next();
		System.out.println("Please enter your roll number");
		int rollNumber=sc.nextInt();
		Student student = new Student(name, rollNumber);
		System.out.println("Please enter number of subjects");
		int noOfSubjects = sc.nextInt();
		for(int i=1; i<=noOfSubjects; i++) {
			System.out.println("Please enter subject name");
			String subject = sc.next();
			System.out.println("Please enter " +subject+" marks");
			int marks = sc.nextInt();
			student.studentMarks.put(subject, marks);
		}
		studentMap = new HashMap<>();
		studentMap.put(rollNumber, student);
		System.out.println("Student data added");
		calculatePercentage(student.studentMarks, noOfSubjects);
		App.run();
		}
	
/* This updatestudent method will take as rollNumber to be updated and gets the data from
 * HashMap and updates the new Student data into the HashMap according to the data given in
 * the console by the user */
	public static void updateStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter rollNumber to be updated");
		int rollNumber = sc.nextInt();
		Set<Integer> set = studentMap.keySet();
		for(Integer temp:set) {
			if(rollNumber==temp) {
				System.out.println("rollNumber Exits");
				System.out.println("Please enter name to be updated");
				String name = sc.next();
				Student student = studentMap.get(rollNumber);
				student.name=name;
				System.out.println("Please enter number of subjects");
				int noOfSubjects = sc.nextInt();
				for(int i=1; i<=noOfSubjects; i++) {
					System.out.println("Please enter subject name");
					String subject = sc.next();
					System.out.println("Please enter " +subject+" marks");
					int marks = sc.nextInt();
					student.studentMarks.put(subject, marks);
					studentMap.put(rollNumber, student);
					System.out.println("Student data updated");
				}
			}
			else {
				System.out.println("rollNumber Doesn't exits");
			}
		}
		
}
/*this deleteStudentData method will take the input roll Number to be deleted and gets the data 
 * from the HashMap and then Student data will be deleted by using remove method   */
	public static void deleteStudentData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter roll Number to be deleted");
		int rollNumber = sc.nextInt();
		if(studentMap.containsKey(rollNumber)) {
	    	 studentMap.remove(rollNumber);
	    	 System.out.println("Student" + rollNumber + " removed ");
	     }
		else {
			System.out.println("Invalid rollNumber");
		}
		
	}
/* This method will calculate the percentage of the Student */
	public static void calculatePercentage(Map<String,Integer> studentMarks,int noOfSubjects) {
		Collection<Integer> c =  studentMarks.values();
        double addition=0;
	    for(Integer temp:c) {
	    	 addition = addition+temp;
	    	 }
	    double percentage = addition/(noOfSubjects*100);
	    percentage = percentage*100;
	    
	    System.out.println("Your percentage is "+percentage+" %");
		
		 
	
	    
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + ", studentMarks=" + studentMarks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, rollNumber, studentMarks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && rollNumber == other.rollNumber
				&& Objects.equals(studentMarks, other.studentMarks);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public Map<String, Integer> getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(Map<String, Integer> studentMarks) {
		this.studentMarks = studentMarks;
	}
	public static Map<Integer, Student> getStudentMap() {
		return studentMap;
	}
	public static void setStudentMap(Map<Integer, Student> studentMap) {
		Student.studentMap = studentMap;
	}
	

}
