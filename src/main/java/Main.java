package main.java;

import java.util.Scanner;

import main.java.service.ICourseService;
import main.java.service.IDepartmentService;
import main.java.service.IStudentService;
import main.java.service.serviceImpl.CourseService;
import main.java.service.serviceImpl.DepartmentService;
import main.java.service.serviceImpl.StudentService;

public class Main {

	public static void main(String[] args) {
		IStudentService studentService = new StudentService();
		IDepartmentService departmentService = new DepartmentService();
		ICourseService courseService = new CourseService();
		
		boolean exit = false;
		while (exit == false) {
			System.out.println();
			System.out.println(" __________________________________________");
			System.out.println("|  WELECOME TO COLLEGE MANAGEMENT SYSTEM   |");
			System.out.println("|__________________________________________|");
			System.out.println("What do you want to manage:");
			System.out.println("1- Student Management");
			System.out.println("2- Department Management");
			System.out.println("3- Course Management");
			System.out.println("4- Exit");
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.print("Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
				studentService.studentManagement();
				break;
			}
			case 2: {
				departmentService.departmentManagement();
				break;
			}
			case 3: {
				courseService.courseManagement();
				break;
			}
			case 4: {
				exit = true;
				break;
			}
			default: {
				System.out.println("Invalid Choice!!!");
			}

			}
		}
	}

}
