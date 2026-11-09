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
	 * @param studentDao
	 * @return
	 */
	@Bean 
	CommandLineRunner commandLineRunner (AppDao app) {
		return runner -> {
		/* --- THESE METHODS ARE FROM THE SECOND BRANCH --- */
			// createInstructor(app);
			// findInstructor(app);
			// deleteInstructor(app);
			// findInstructorDetail(app);
			//  deleteInstructorDetail(app);

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

	private void findInstructor(AppDao app){
		int id = 2;
		System.out.println("Find id: " + id);

		Instructor teach = app.findInstructorById(id);

		System.out.println("Instructor: " + teach);
		System.out.println("Details: " + teach.getInstructorInfo());
	}

	private void deleteInstructor(AppDao app){
		int id = 1;
		System.out.println("Deleting id: " + id);

		app.deleteInstructorById(id);

		System.out.println("Deleted successfully");
	}

	private void findInstructorDetail(AppDao app){
		int id = 3;
		InstructorDetail tInfo = app.findInstructorDetailsById(id);

		System.out.println("Details: " + tInfo);
		System.out.println("Instructor: " + tInfo.getInstructor());
	}

	private void deleteInstructorDetail(AppDao app){
		int id = 3;
		System.out.println("Deleting id: " + id);

		app.deleteInstructorDetailById(id);
		System.out.println("Delete successful.");
	}
}

