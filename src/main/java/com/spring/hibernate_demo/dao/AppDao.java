package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Instructor;

public interface AppDao {
    void save(Instructor theTeacher);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
