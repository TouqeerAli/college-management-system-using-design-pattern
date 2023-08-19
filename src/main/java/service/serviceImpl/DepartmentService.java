package main.java.service.serviceImpl;

import java.util.List;
import java.util.Scanner;

import main.java.dao.DepartmentDAO;
import main.java.dao.impl.DepartmentDAOImpl;
import main.java.model.Department;
import main.java.service.IDepartmentService;

public class DepartmentService implements IDepartmentService {
	DepartmentDAO departmentDAO = new DepartmentDAOImpl();

	@Override
	public Department addDept() {
		Scanner sc = new Scanner(System.in);
		Department dept = new Department();

		System.out.println("************************");
		System.out.println("Enter department ID: ");
		dept.setId(sc.nextInt());
		System.out.println("Enter department Name: ");
		dept.setName(sc.next());

		return dept;
	}

	@Override
	public Integer deleteDept() {
		System.out.println("************************");
		System.out.println("Enter department ID you want to Delete: ");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();

		return id;
	}

	@Override
	public Department updateDept() {
		System.out.println("************************");
		System.out.println("Enter department ID you want to Update: ");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();

		Department d = departmentDAO.getDepartment(id);
		d.setId(id);
		System.out.println("Enter  Department Name: ");
		sc.nextLine();
		d.setName(sc.nextLine());

		return d;
	}

	@Override
	public void getAllDept() {
		List<Department> list = departmentDAO.getAllDepartment();
		for (Department d : list) {
			System.out.println("---------");
			System.out.println("ID : " + d.getId());
			System.out.println("Name : " + d.getName());
		}

	}

	@Override
	public Integer getDeptInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("************************");
		System.out.println("Enter Department ID: ");

		return sc.nextInt();
	}

	public void departmentManagement() {
		boolean exit = false;
		while (exit == false) {
			System.out.println("---------- WELECOME TO DEPARTMENT MANAGEMENT----------");
			System.out.println("Select from following: ");
			System.out.println("1- Add Department");
			System.out.println("2- Update Department");
			System.out.println("3- Delete Department");
			System.out.println("4- Get Department");
			System.out.println("5- Get All Department");
			System.out.println("6- Exit");
			Scanner sc = new Scanner(System.in);
			System.out.print("Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {

				departmentDAO.addDepartment(addDept());

				break;
			}
			case 2: {
				departmentDAO.updateDepartment(updateDept());
				break;
			}
			case 3: {
				departmentDAO.deleteDepartment(deleteDept());
				break;
			}
			case 4: {
				departmentDAO.getDepartmentInfo(getDeptInfo());
				break;
			}
			case 5: {
				getAllDept();
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
}
