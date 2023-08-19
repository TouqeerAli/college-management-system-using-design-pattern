package main.java.service;

import main.java.model.Course;

public interface ICourseService {
	public void courseManagement();
	public Course addCourse();
	public Course updateCourse();
	public Integer deleteCourse();
	public Integer getCourseInfo();
	public void getAllCourses();
	
	
}
