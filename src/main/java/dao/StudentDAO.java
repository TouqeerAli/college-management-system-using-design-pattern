package main.java.dao;

import main.java.model.Student;

public interface StudentDAO {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public Student getStudent(Integer id);
	public void getStudentInfo(Integer id);
	public void getAllStudentInfo();
	public void deleteStudent(Integer id);
	
	
}
