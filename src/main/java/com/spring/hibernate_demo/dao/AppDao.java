package com.spring.hibernate_demo.dao;

import java.util.List;

import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theTeacher);
    void save(Course theCourse);
    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailsById(int id);
    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor in);
}
