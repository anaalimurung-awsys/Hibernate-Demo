package com.spring.hibernate_demo;

import com.spring.hibernate_demo.dao.AppDao;
// import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
// import com.spring.hibernate_demo.entity.Student;
// import java.util.List;
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
	 * @param app
	 * @return
	 */
	@Bean 
	CommandLineRunner commandLineRunner (AppDao app) {
		return runner -> {
			createInstructor(app);

			/* --- THESE METHODS ARE FROM THE MAIN BRANCH --- */
			// createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudent(studentDao);
		};
	}

	/**
	 * Method to create instructor and details.
	 * @param app
	 */
	private void createInstructor(AppDao app) {
		Instructor teach1 = new Instructor("Shota",
											"Aizawa",
											"shota.aizawa@ua.com");
		InstructorDetail info = new InstructorDetail("Homeroom",
													"Taking care of cats");
		
		// this associates the objects
		teach1.setInstructorInfo(info);
		System.out.println("Details saved!");
		app.save(teach1);
	}
}

