package main.java.dao;

import java.util.List;

import main.java.model.Course;

public interface CourseDAO {
	public void addCourse(Course course);
	public Course getCourse(Integer id);
	public void updateCourse(Course course);
	public void deleteCourse(Integer id);
	public void getCourseInfo(Integer id);
	public List<Course> getAllCourses();
	
}
