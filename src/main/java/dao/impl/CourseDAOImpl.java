package main.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.dao.CourseDAO;
import main.java.dbConnection.DbConnection;
import main.java.model.Course;

public class CourseDAOImpl implements CourseDAO {
	private final String INSERT_QUERY = "INSERT INTO course(c_id, c_name) VALUES (?, ?)";
	private final String SELECT_BY_ID_QUERY = "SELECT c_id,c_name FROM course WHERE c_id= ?";
	private final String UPDATE_QUERY = "UPDATE course SET c_name=? WHERE c_id=?";
	private final String DELETE_QUERY = "DELETE FROM course WHERE c_id=?";
	private final String SELECT_QUERY = "SELECT * FROM course";

	@Override
	public void addCourse(Course course) {
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setInt(1, course.getId());
			ps.setString(2, course.getName());

			ps.execute();

			System.out.println("Course Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Course getCourse(Integer id) {
		Connection con = DbConnection.getConnection();
		Course d = new Course();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				d.setId(rst.getInt("c_id"));
				d.setName(rst.getString("c_id"));
			}
			return d;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateCourse(Course course) {
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, course.getName());
			ps.setInt(2, course.getId());
			ps.execute();
			System.out.println("Course Updated.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCourse(Integer id) {
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Course deleted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getCourseInfo(Integer id) {
		Connection con = DbConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				System.out.println("ID : " + rst.getInt("c_id"));
				System.out.println("Name : " + rst.getString("c_name"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Course> getAllCourses() {
		Connection con = DbConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rst = ps.executeQuery();

			List<Course> courseList = new ArrayList<>();

			while (rst.next()) {
				Course c = new Course();
				c.setId(rst.getInt("c_id"));
				c.setName(rst.getString("c_name"));

				courseList.add(c);
			}
			return courseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
