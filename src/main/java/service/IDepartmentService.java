package main.java.service;

import main.java.model.Department;

public interface IDepartmentService {
	public Department addDept();
	public Integer deleteDept();
	public Department updateDept();
	public void getAllDept();
	public Integer getDeptInfo();
	public void departmentManagement();
}
