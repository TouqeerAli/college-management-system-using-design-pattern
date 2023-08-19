package main.java.service;

import main.java.model.Student;

public interface IStudentService {
	public Student add();
	public Student update();
	public Integer getStudentInfo();
	public Integer deleteStudent();
	public void studentManagement();
}
