package com.spring.hibernate_demo;

import com.spring.hibernate_demo.dao.AppDao;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Review;
import com.spring.hibernate_demo.entity.Student;

import java.util.List;

// import com.spring.hibernate_demo.entity.Student;
// import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * HibernateDemoApplication.
 * Used for testing cases
 * Serves as the main class
 */
@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	/**
	 * This is the command line runner.
	 * @param app
	 * @param studentDao
	 * @return
	 */
	// @Bean 
	CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
		/* --- THESE METHODS ARE FROM THE MAIN BRANCH --- */
			createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudent(studentDao);
		};
	}

	/**
	 * This is the command line for the second branch.
	 * @param app
	 * @return
	 */
	// @Bean 
	// CommandLineRunner commandLineRunner (AppDao app) {
	// 	return runner -> {
	// 	/* --- THESE METHODS ARE FROM THE SECOND BRANCH --- */
	// 		// createInstructor(app);
	// 		// findInstructor(app);
	// 		// deleteInstructor(app);
	// 		// findInstructorDetail(app);
	// 		// deleteInstructorDetail(app);
	// 		// createInstructorWithCourses(app);
	// 		// findInstructorWithCourses(app);
	// 		// findInstructorWithCoursesJoinFetch(app);
	// 		// updateInstructor(app);
	// 		// deleteInstructorOnly(app);
	// 		// createCourseAndReviews(app);
	// 		// retrieveCourseAndReviews(app);
	// 		// deleteCourseAndReviews(app);
	// 		// createCourseAndStudents(app);
	// 		// findCourseAndStudents(app);
	// 		// findStudentAndCourses(app);
	// 		// addMoreCoursesForStudents(app);
	// 		// deleteCourseById(app);
	// 		deleteStudent(app);
	// 	};
	// }

	/**
	 * Method to create student information.
	 * @param studentDao
	 */
	private void createStudent(StudentDao studentDao){
		System.out.println("Creating student information...");
		Student student6 = new Student("Albedo",
										"Kreideprinz",
										"albedo.kreideprinz@kof.com");
		Student student5 = new Student("Klee",
										"Kreideprinz",
										"klee.kreideprinz@kof.com");
		Student student4 = new Student("Lune",
										"Kreideprinz",
										"lune.kreideprinz@hex.com");								
		
		System.out.println("Saving student information...");
		studentDao.save(student4);
		studentDao.save(student5);
		studentDao.save(student6);

		System.out.println("Saved. Generated id: " + student4.getId());
	}

	/**
	 * Method to read data from database
	 * @param studentDao
	 */
	private void readStudent(StudentDao studentDao) {
		Student student = studentDao.findById(2);
		System.out.println("Retrieving student id " + student.getId());
		
		System.out.println("Found: " + student);
	}

	/**
	 * Method to select data.
	 * @param studentDao
	 */
	private void queryStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();

		for(Student s : students) {
			System.out.println(s);
		}
	}

	/**
	 * Method to update data.
	 * @param studentDao
	 */
	private void updateStudent(StudentDao studentDao) {
		int id = 1;
		System.out.println("Student ID: " + id);
		Student stud = studentDao.findById(id);

		System.out.println("Updating student name...");
		stud.setFirstName("Rei");

		studentDao.update(stud);

		System.out.println("Updated student information: " + stud);
	}

	/**
	 * Method to delete information.
	 * @param studentDao
	 */
	private void deleteStudent(StudentDao studentDao){
		int id = 2;
		System.out.println("Deleting id: " + id);

		studentDao.deleteStudent(id);
	}

	/**
	 * Method to delete all information
	 * @param studentDao
	 */
	private void deleteAllStudent(StudentDao studentDao){
		System.out.println("Deleting all data...");
		int deletedRows = studentDao.deleteAll();
		System.out.println("Number of deleted rows: " + deletedRows);
	}

	/**
	 * Method to create instructor and details.
	 * @param app
	 */
	private void createInstructor(AppDao app) {
		Instructor teach1 = new Instructor("Shota",
											"Aizawa",
											"shota.aizawa@ua.com");
		InstructorDetail info1 = new InstructorDetail("Homeroom",
													"Taking care of cats");
		
		Instructor teach2 = new Instructor("Hatake",
											"Kakashi",
											"hatake.kakashi@hunter.com");
		InstructorDetail info2 = new InstructorDetail("Ninjutsu",
													"Reading Icha-Icha");
		Instructor teach3 = new Instructor("Irina",
											"Jelavic",
											"irina.jelavic@sangumi.com");
		InstructorDetail info3 = new InstructorDetail("English",
													"Playing the piano");
		
		Instructor teach4 = new Instructor("Biscuit",
											"Krueger",
											"biscuit.krueger@hunter.com");
		InstructorDetail info4 = new InstructorDetail("Hunter",
											"Double-Star Stone Hunter");

		// this associates the objects
		teach1.setInstructorInfo(info1);
		teach2.setInstructorInfo(info2);
		teach3.setInstructorInfo(info3);
		teach4.setInstructorInfo(info4);

		System.out.println("Details saved!");
		app.save(teach1);
		app.save(teach2);
		app.save(teach3);
		app.save(teach4);
	}

	/**
	 * Method to search for instructor id.
	 * @param app
	 */
	private void findInstructor(AppDao app){
		int id = 2;
		System.out.println("Find id: " + id);

		Instructor teach = app.findInstructorById(id);

		System.out.println("Instructor: " + teach);
		System.out.println("Details: " + teach.getInstructorInfo());
	}

	/**
	 * Method to delete Instructor using id.
	 * @param app
	 */
	private void deleteInstructor(AppDao app){
		int id = 1;
		System.out.println("Deleting id: " + id);

		app.deleteInstructorById(id);

		System.out.println("Deleted successfully");
	}

	/**
	 * Method to find instructor's detail by id.
	 * @param app
	 */
	private void findInstructorDetail(AppDao app){
		int id = 3;
		InstructorDetail tInfo = app.findInstructorDetailsById(id);

		System.out.println("Details: " + tInfo);
		System.out.println("Instructor: " + tInfo.getInstructor());
	}

	/**
	 * Method to delete instructor details by id.
	 * @param app
	 */
	private void deleteInstructorDetail(AppDao app){
		int id = 3;
		System.out.println("Deleting id: " + id);

		app.deleteInstructorDetailById(id);
		System.out.println("Delete successful.");
	}
	
	/**
	 * Method to create instructors with courses.
	 * @param app
	 */
	private void createInstructorWithCourses(AppDao app) {
		Instructor teach1 = new Instructor("Albedo",
											"Kreidiprinz",
											"albedo.kreidiprinz@kof.com");
		InstructorDetail info1 = new InstructorDetail("Alchemy",
														"Making art");	
		
		teach1.setInstructorInfo(info1);

		Course course1 = new Course("Alchemy");
		Course course2 = new Course("Art");

		teach1.add(course1);
		teach1.add(course2);

		System.out.println("Courses saved: " + teach1.getCourses());
		app.save(teach1);
	}

	/**
	 * Method to find instructor thru courses
	 * @param app
	 */
	private void findInstructorWithCourses(AppDao app) {
		int id = 5;
		
		System.out.println("Find instructor id: " + id);
		Instructor teach = app.findInstructorById(id);

		System.out.println("Instructor: " + teach);
		System.out.println("Courses from id: " + id);

		List<Course> courses = app.findCoursesByInstructorId(id);
		teach.setCourses(courses);
		System.out.println(teach.getCourses());
	}

	/**
	 * Method to find instructor thru courses with join fetch.
	 * @param app
	 */
	private void findInstructorWithCoursesJoinFetch(AppDao app) {
		int id = 5;
		System.out.println("Find instructor id: " + id);
		
		Instructor teach = app.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + teach);
		System.out.println("Courses: " + teach.getCourses());
	}

	/**
	 * Method to update details of instructor.
	 * @param app
	 */
	private void updateInstructor(AppDao app) {
		int id = 3;

		Instructor ins = app.findInstructorById(id);

		ins.setLastName("Karasuma");
		
		System.out.println("Updated");
		app.update(ins);
	}

	/**
	 * Method to delete instructor without deleting the course
	 * associated with it.
	 * @param app
	 */
	private void deleteInstructorOnly(AppDao app) {
		int id = 7;
		System.out.println("Delete instructor: " + id);

		app.deleteInstructorById(id);
		System.out.println("Deleted successfully");
	}

	/**
	 * Method to create reviews for a course.
	 * @param app
	 */
	private void createCourseAndReviews(AppDao app) {
		Course c = new Course("How to Speed Run Spring in 2 hours");

		c.addReview(new Review("Thanks for the run, I have a test tomorrow"));
		c.addReview(new Review("Loved it but I wanted the speed 0.75x"));
		c.addReview(new Review("Challenge: do a 3x speed"));

		System.out.println("Course saved");
		app.save(c);
	}

	/**
	 * Method to retrieve courses and its reviews.
	 * @param app
	 */
	private void retrieveCourseAndReviews(AppDao app) {
		int id = 7;
		System.out.println("Get course and reviews of " + id);

		Course course = app.findCourseAndReviewsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getReview());
	}

	/**
	 * Method to delete course and its review.
	 * @param app
	 */
	private void deleteCourseAndReviews(AppDao app) {
		int id = 7;
		System.out.println("Deleting course: " + id);
		
		app.deleteCourseById(id);

		System.out.println("Delete successful.");
	}

	/**
	 * Method to create students with courses.
	 * @param app
	 */
	private void createCourseAndStudents(AppDao app) {
		Course course = new Course("Alchemy 101");

		Student student1 = new Student("Albedo",
										"Kreideprinz",
										"albedo.kreideprinz@kof.com");
		Student student2 = new Student("Dan Heng",
										"Fan",
										"danheng.fang@xianzhou.com");
		
		course.addStudent(student1);
		course.addStudent(student2);

		app.save(course);
		System.out.println("Enroll successful");
	}

	/**
	 * Method to find courses and students.
	 * Using Course as the owning table
	 * Through Join query 
	 * @param app
	 */
	private void findCourseAndStudents(AppDao app) {
		int id = 8;

		Course course = app.findCourseAndStudentByCourseId(id);

		System.out.println("Course " + course);
		System.out.println("Students: " + course.getStudents());
	}

	/**
	 * Method to find student and courses.
	 * Using Student as the owning table
	 * Through Join query
	 * @param app
	 */
	private void findStudentAndCourses(AppDao app) {
		int id = 1;

		Student stud = app.findStudentAndCoursesByStudentId(id);

		System.out.println("Student: " + stud);
		System.out.println("Courses: " + stud.getCourses());
	}

	/**
	 * Method to add courses for students.
	 * @param app
	 */
	private void addMoreCoursesForStudents(AppDao app) {
		int id = 2;
		Student student1 = app.findStudentAndCoursesByStudentId(id);

		Course c1 = new Course("History of the Nameless");
		Course c2 = new Course("The Guide to Amphoreus");
		Course c3 = new Course("Basics of Cloudhymn Magic");

		student1.addCourse(c1);
		student1.addCourse(c2);
		student1.addCourse(c3);

		System.out.println("Successfully enrolled to another course");

		app.update(student1);
	}

	/**
	 * Method to delete course by id.
	 * @param app
	 */
	private void deleteCourseById(AppDao app) {
		int id = 9;
		System.out.println("Delete course " + id);

		app.deleteCourseById(id);

		System.out.println("Delete successful");
	}

	/**
	 * Method to delete student by id
	 * @param app
	 */
	private void deleteStudent(AppDao app) {
		int id = 4;
		System.out.println("Delete stud: " + id);

		app.deleteStudentById(id);
		System.out.println("Delete successful");
	}
}

