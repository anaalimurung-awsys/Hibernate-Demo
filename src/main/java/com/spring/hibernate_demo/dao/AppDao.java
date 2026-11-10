package com.spring.hibernate_demo.dao;

import java.util.List;

import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Student;

public interface AppDao {
    void save(Instructor theTeacher);
    void save(Course theCourse);
    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailsById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    Course findCourseAndReviewsByCourseId(int id);
    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
    void deleteCourseById(int id);
    void update(Instructor in);
    void update(Student stud);
    Course findCourseAndStudentByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void deleteStudentById(int id);
}
