package com.spring.hibernate_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Bean 
	CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
			// createStudent(studentDao);
			readStudent(studentDao);
		};
	}

	/**
	 * Method to create student information.
	 * @param studentDao
	 */
	private void createStudent(StudentDao studentDao){
		System.out.println("Creating student information...");
		Student student = new Student("Ree",
										"Ash",
										"ree.ash@ccg.com");
		
		System.out.println("Saving student information...");
		studentDao.save(student);

		System.out.println("Saved. Generated id: " + student.getId());
	}

	private void readStudent(StudentDao studentDao) {
		Student student = studentDao.findById(2);
		System.out.println("Retrieving student id " + student.getId());
		
		System.out.println("Found: " + student);
	}
}
