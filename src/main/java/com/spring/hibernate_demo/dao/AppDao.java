package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theTeacher);
    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailsById(int id);
    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
}
