package com.spring.hibernate_demo;

import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	/**
	 * This is the command line runner.
	 * @param studentDao
	 * @return
	 */
	@Bean 
	CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
			// createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			queryStudentByLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudent(studentDao);
		};
	}

	/**
	 * Method to create student information.
	 * @param studentDao
	 */
	private void createStudent(StudentDao studentDao){
		System.out.println("Creating student information...");
		Student student6 = new Student("Rubedo",
										"Kreideprinz",
										"rubedo.kreideprinz@kof.com");
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
	 * Method to query students by last name
	 * @param studentDao
	 */
	private void queryStudentByLastName (StudentDao studentDao) {
		List<Student> studs = studentDao.findByLastName("Kreideprinz");

		for(Student s : studs) {
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
}
