package main.java.dao;

import java.util.List;

import main.java.model.Department;

public interface DepartmentDAO {
	public List<Department> getAllDepartment();
	public Department getDepartment(Integer id);
	public void getDepartmentInfo(Integer id);
	public void addDepartment(Department department);
	public void deleteDepartment(Integer id);
	public void updateDepartment(Department department);
	
}
