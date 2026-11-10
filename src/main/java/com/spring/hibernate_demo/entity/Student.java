package com.spring.hibernate_demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Student class as entity.
 */
@Entity 
@Table(name = "student") 
public class Student {

    /**
     * This is the column for the student id.
     * Set as primary key
     */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    /**
     * This is the column for the first name.
     */
    @Column (name = "first_name")
    private String firstName;

    /**
     * This is the column for the last name.
     */
    @Column (name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    @ManyToMany (mappedBy = "students",
                fetch=FetchType.LAZY,
                cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Course> courses;

    /**
     * Non-parameterized constructor.
     */
    public Student(){
    }

    /**
     * Parameterized constructor.
     * @param fName
     * @param lName
     * @param email
     */
    public Student(String fName, String lName, String email){
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
    }

    /**
     * Getters and setters for all the fields.
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override 
    public String toString() {
        return "Student [id=" + id
                + ", firstName =" + firstName
                + ", lastName=" + lastName
                + ", email=" + email + "]";
    }

    public void addCourse(Course course) {
        if(courses == null) courses = new ArrayList<>();

        courses.add(course);
        course.addStudent(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
