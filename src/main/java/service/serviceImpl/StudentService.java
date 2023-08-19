package main.java.service.serviceImpl;

import java.util.List;
import java.util.Scanner;

import main.java.dao.DepartmentDAO;
import main.java.dao.StudentDAO;
import main.java.dao.impl.DepartmentDAOImpl;
import main.java.dao.impl.StudentDAOImpl;
import main.java.model.Department;
import main.java.model.Student;
import main.java.service.IStudentService;

public class StudentService implements IStudentService {
	StudentDAO studentDAO = new StudentDAOImpl();
	DepartmentDAO departmentDAO = new DepartmentDAOImpl();

	public void studentManagement() {
		boolean exit = false;
		while (exit == false) {
			System.out.println("\n---------- WELECOME TO STUDENT MANAGEMENT----------");
			System.out.println("Select from following: ");
			System.out.println("1- Add Student");
			System.out.println("2- Update Student");
			System.out.println("3- Delete Student");
			System.out.println("4- Get Student Info");
			System.out.println("5- Get All Student Info");
			System.out.println("6- Exit");
			Scanner sc = new Scanner(System.in);
			System.out.print("Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {

				 studentDAO.addStudent(add());

				break;
			}
			case 2: {
				studentDAO.updateStudent(update());
				break;
			}
			case 3: {
				studentDAO.deleteStudent(deleteStudent());
				break;
			}
			case 4: {
				studentDAO.getStudentInfo(getStudentInfo());
				break;
			}
			case 5: {
				studentDAO.getAllStudentInfo();
				break;
			}
			case 6: {
				exit = true;
				break;
			}
			default: {
				System.out.println("Invalid choice!!!");
			}

			}
		}
	}

	@Override
	public Student add() {
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		System.out.println("************************");
		System.out.println("Enter student ID: ");
		st.setId(sc.nextInt());
		System.out.println("Enter student name: ");
		st.setName(sc.next());
		System.out.println("Enter student age: ");
		st.setAge(sc.nextInt());
		System.out.println("Enter student email: ");
		st.setEmail(sc.next());

		boolean exit = false;
		Department d = new Department();
		while (exit == false) {
			System.out.println("Enter Department ID from following: ");

			List<Department> list = departmentDAO.getAllDepartment();
			System.out.println("    ID  NAME");
			System.out.println("    --------");
			for (Department dept : list) {
				System.out.print("    " + dept.getId() + " ");
				System.out.println("    " + dept.getName());
			}
			Integer ch = sc.nextInt();

			for (Department dpt : list) {
				if (dpt.getId() == ch) {
					d.setId(ch);
					exit = true;
				} else if (dpt.getId() == ch && (list.indexOf(dpt) == list.size() - 1)) {
					System.out.println("It doesn't exist, try again");
				}
			}
		}
		st.setDepartment(d);

		return st;
	}

	@Override
	public Student update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("************************");
		System.out.println("Enter the student ID you want to Update.");
		Integer id = sc.nextInt();

		Student st = studentDAO.getStudent(id);
		st.setId(id);
		System.out.println("Enter the new Name: ");
		sc.nextLine();
		st.setName(sc.nextLine());

		return st;
	}

	@Override
	public Integer getStudentInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("************************");
		System.out.println("Enter Student ID: ");

		return sc.nextInt();
	}

	@Override
	public Integer deleteStudent() {
		System.out.println("************************");
		System.out.println("Enter student ID you want to Delete: ");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();

		return id;
	}
}
