package com.spring.hibernate_demo.dao;

import java.util.List;

import com.spring.hibernate_demo.entity.Student;

public interface StudentDao {
    void save(Student myStudent);
    Student findById(Integer id);
    List<Student> findAll();
    void update(Student myStudent);
    void deleteStudent(Integer id);
    int deleteAll();
}
