package unl.cse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Course {

	private static org.apache.log4j.Logger log = Logger.getLogger(Course.class);

	private Integer courseId;
	private String name;
	private String descrption;
	
	public Course() {
	}
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String toString() {
		return this.name + " - " + this.descrption;
	}
	
	public static void addCourse(String name, String description) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USERNAME, DatabaseInfo.PASSWORD);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		String query = "INSERT INTO course (name, description) VALUES (?, ?)";
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			try {
				if(ps != null && !ps.isClosed())
					ps.close();
				if(conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				log.error("SQLException: ", e);
				throw new RuntimeException(e);
			}
		}		
	}
	
	public static Course getCourseByName(String courseName) {
		
		Course c = new Course();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			log.error("InstantiationException: ", e);
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			log.error("IllegalAccessException: ", e);
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			log.error("ClassNotFoundException: ", e);
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USERNAME, DatabaseInfo.PASSWORD);
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}
		

		String query = "SELECT course_id  AS courseId,   " +
					   "       name       AS courseName, " +
		               "       description AS description  " +
		               "FROM course " +
		               "WHERE name = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			//unfortunately, JDBC does not support named parameters
			ps.setString(1, courseName);
			rs = ps.executeQuery();
			if(rs.next()) {
				c.setCourseId(rs.getInt("courseId"));
				c.setName(rs.getString("courseName"));
				c.setDescrption(rs.getString("description"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}

		try {
			if(rs != null && !rs.isClosed())
				rs.close();
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}
		
		return c;
	}
	
	/**
	 * Removes all courses in the database
	 */
	public static void removeAll() {
		removeAllEnrollmentRecords();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USERNAME, DatabaseInfo.PASSWORD);
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}

		String query = "DELETE FROM course";
		
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}

	}

	public static void removeAllEnrollmentRecords() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USERNAME, DatabaseInfo.PASSWORD);
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}
		

		String query = "DELETE FROM enrollment";
		
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}

		try {
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			log.error("SQLException: ", e);
			throw new RuntimeException(e);
		}
	}

}
