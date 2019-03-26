package studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		//Ask how many users we want to add to the database
		System.out.print("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int numOfStudents = in.nextInt();
		in.close();
		Student[] students = new Student[numOfStudents];
		//Create n number of new students
		for (int n = 0; n < numOfStudents; n++) {
			students[n] = new Student();
			students[n].enroll();
			students[n].payTuition();
		}
		
		for (int n = 0; n < numOfStudents; n++) {
			System.out.println(students[n].toString());
		}
		
	}

}
