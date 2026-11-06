package com.spring.hibernate_demo.dao;

import java.util.List;

import com.spring.hibernate_demo.entity.Student;

/**
 * Interface.
 * StudentDao
 */
public interface StudentDao {
    void save(Student myStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student myStudent);
    void deleteStudent(Integer id);
    int deleteAll();
}
