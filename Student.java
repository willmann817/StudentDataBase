package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	//class attributes are private consistent with encapsulation principle
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600; //static because it belongs to every object in the class
	private static int id = 1000;          //will increment this value each time we create a new student and
										   //assign it to studentID with the grade level in front
	
	//Constructor that prompts user to enter student's name & year
	public Student() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("What is the student class level?\n1- Freshman\n2- Sophomore\n3- Junior\n4- Senior\n"
				+ "Please enter the number from list above list: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
		
		//System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
		
		in.close();
		
	}
	//Generate an ID number for student
	private void setStudentID() {
		//Grade level + ID
		id++; //increment for each new student
		this.studentID = gradeYear + "" + id;
	}
	//Enroll student in courses
	public void enroll() {
		//get inside a loop, user hits Q to quit
		String course;
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			course = in.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break;
			}
		} while (true); 
			
		//System.out.println("ENROLLED IN: " + courses);
		in.close();
	}
	
	//View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	//pay tuition
	public void payTuition() {
		viewBalance();
		int payment;
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
		in.close();
	}
	//Show status
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nGrade Level: " + gradeYear +
				"\nStudent ID:" + studentID +
				"\nCourses Enrolled:" + courses +
				"\nBalance: $" + tuitionBalance;
	}
}
