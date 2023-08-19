package main.java.service.serviceImpl;

import java.util.List;
import java.util.Scanner;

import main.java.dao.CourseDAO;
import main.java.dao.impl.CourseDAOImpl;
import main.java.model.Course;
import main.java.service.ICourseService;

public class CourseService implements ICourseService{
	CourseDAO courseDAO = new CourseDAOImpl();
	
	@Override
	public Course addCourse() {
		Scanner sc = new Scanner(System.in);
		Course c = new Course();

		System.out.println("************************");
		System.out.println("Enter course ID: ");
		c.setId(sc.nextInt());
		System.out.println("Enter course Name: ");
		c.setName(sc.next());

		return c;

	}

	@Override
	public Course updateCourse() {
		Scanner sc = new Scanner(System.in);

		System.out.println("************************");
		System.out.println("Enter the course ID you want to Update.");
		Integer id = sc.nextInt();

		Course c = courseDAO.getCourse(id);
		c.setId(id);
		System.out.println("Enter the new Course Name: ");
		sc.nextLine();
		c.setName(sc.nextLine());

		return c;
	}

	@Override
	public Integer deleteCourse() {
		System.out.println("************************");
		System.out.println("Enter course ID you want to Delete: ");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();

		return id;
	}

	@Override
	public Integer getCourseInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("************************");
		System.out.println("Enter Course ID: ");

		return sc.nextInt();
	}

	@Override
	public void getAllCourses() {
		List<Course> list = courseDAO.getAllCourses();
		for (Course d : list) {
			System.out.println("---------");
			System.out.println("ID : " + d.getId());
			System.out.println("Name : " + d.getName());
		}
	}
	
	@Override
	public void courseManagement() {
		
			boolean exit=false;
			while(exit == false) {
			System.out.println("\n---------- WELECOME TO COURSE MANAGEMENT----------");
			System.out.println("Select from following: ");
			System.out.println("1- Add Course");
			System.out.println("2- Update Course");
			System.out.println("3- Delete Course");
			System.out.println("4- Get Course Info");
			System.out.println("5- Get All Courses Info");
			System.out.println("6- Exit");
			Scanner sc = new Scanner(System.in);
			System.out.print("Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
				courseDAO.addCourse(addCourse());
				break;
			}
			case 2: {
				courseDAO.updateCourse(updateCourse());
				break;
			}
			case 3: {
				courseDAO.deleteCourse(deleteCourse());
				break;
			}
			case 4: {
				courseDAO.getCourseInfo(getCourseInfo());
				break;
			}
			case 5: {
				getAllCourses();
				break;
			}
			case 6: {
				exit=true;
				break;
			}
			default: {
				System.out.println("Invalid choice!!!");
			}

			}
			
		}
		
	}


}
