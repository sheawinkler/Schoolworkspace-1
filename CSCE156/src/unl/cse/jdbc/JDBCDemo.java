package unl.cse.jdbc;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class JDBCDemo {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(JDBCDemo.class);

	public static void main(String args[]) {

		//alternative to properties file:
		BasicConfigurator.configure();
		
		log.info("Removing all Students...");
		Student.removeAll();
		Course.removeAll();

		Course.addCourse("CSCE 155H", "Computer Science I - Honors");
		Course.addCourse("CSCE 156", "Computer Science II");
		Course.addCourse("CSCE 235", "Discrete Mathematics");
		Course.addCourse("CSCE 424", "Complexity Theory");
		Course.addCourse("MATH 955", "Mathematics of Wonton Burrito Meals");

		String nuid01 = "00001234";
		Student.addStudent("Phillip", "Fry", nuid01, false);
		Student.addEmailToStudent(nuid01, "phry@express1.com");
		Student.addEmailToStudent(nuid01, "pjfry@aol.com");

		String nuid02 = "35140602";
		Student.addStudent("Chris", "Bourke", nuid02, false);
		Student.addEmailToStudent(nuid02, "cbourke@cse.unl.edu");
		Student.addEmailToStudent(nuid02, "cmbourke@gmail.com");
		
		Student.addCourseToStudent(nuid01, "CSCE 424", "Fall 2012");
		Student.addCourseToStudent(nuid01, "MATH 955", "Fall 3003");

		Student roster[] = Student.getAllStudents();
		for(Student s : roster) {
			System.out.println("Student: "+s);
			System.out.println("Courses: ");
			for(Course c : s.getCourses()) {
				System.out.println("\t" + c);
			}
		}
		


		
	}
	
}
