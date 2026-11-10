package com.spring.hibernate_demo.dao;

import java.util.List;

import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Student;

/**
 * Interface for Data Access Object
 * AppDao interface.
 */
public interface AppDao {
    void save(Course theCourse);
    void save(Instructor theTeacher);
    
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentByCourseId(int id);
    InstructorDetail findInstructorDetailsById(int id);
    Instructor findInstructorById(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    List<Course> findCoursesByInstructorId(int id);
    Student findStudentAndCoursesByStudentId(int id);

    void deleteCourseById(int id);
    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
    void deleteStudentById(int id);
    
    void update(Instructor in);
    void update(Student stud);
}
