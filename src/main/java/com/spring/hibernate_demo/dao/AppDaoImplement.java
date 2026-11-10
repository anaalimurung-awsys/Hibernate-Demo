package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Student;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * AppDaoImplement class. 
 * Contains implementations of the
 * Interface AppDao
 */
@Repository 
public class AppDaoImplement implements AppDao {
    
    private EntityManager em;

    /**
     * Constructor for AppDaoImplement
     * @param em
     */
    public AppDaoImplement(EntityManager em) {
        this.em = em;
    }

    @Override 
    @Transactional 
    public void save(Instructor theTeacher) {
            em.persist(theTeacher);
    }

    @Override 
    @Transactional 
    public void save(Course theCourse) {
            em.persist(theCourse);
    }

    @Override 
    public Instructor findInstructorById(int id){
        return em.find(Instructor.class, id);
    }
    
    @Override 
    public InstructorDetail findInstructorDetailsById(int id){
        return em.find(InstructorDetail.class, id);
    } 

    
    @Override 
    @Transactional 
    public void deleteInstructorDetailById(int id){
        InstructorDetail info = em.find(InstructorDetail.class, id);

        info.getInstructor().setInstructorInfo(null);
        em.remove(info);
    }
    
    @Override 
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = em.createQuery(
            "FROM Course WHERE instructor.id=:data", Course.class);
            
            query.setParameter("data", id);
            
            List<Course> courses = query.getResultList();

        return courses;
    }

    @Override 
    public Instructor findInstructorByIdJoinFetch(int id){
        
        TypedQuery<Instructor> query = em.createQuery(
            "SELECT ins from Instructor ins " + 
            "JOIN FETCH ins.courses " + 
            "WHERE ins.id=:data",
            Instructor.class);
            query.setParameter("data", id);
            
            Instructor teach = query.getSingleResult();
            return teach;
        }
        
    @Override 
    @Transactional 
    public void update(Instructor in){
        em.merge(in);
    }

    @Override 
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = em.createQuery(
            "SELECT c FROM Course c " + 
            "JOIN FETCH c.review " +
                "WHERE c.id=:data",
                Course.class  
            );
            
            query.setParameter("data", id);
            Course course = query.getSingleResult();
            
            return course;
        }
        
        @Override 
        @Transactional 
        public void deleteCourseById(int id) {
            Course course = em.find(Course.class, id);
            em.remove(course);
        }
        
        @Override 
        public Course findCourseAndStudentByCourseId(int id) {
            TypedQuery<Course> query = em.createQuery(
                "SELECT c FROM Course c " +
                "JOIN FETCH c.students " +
                "WHERE c.id=:data",
                Course.class
            );
            
            query.setParameter("data", id);
            Course course = query.getSingleResult();
            
            return course;
        }
        
        @Override 
        public Student findStudentAndCoursesByStudentId(int id){
            TypedQuery<Student> query = em.createQuery(
                "SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id=:data",
                Student.class  
            );

            query.setParameter("data", id);
            
            Student stud = query.getSingleResult();
            
            return stud;
        }

    @Override 
    @Transactional 
    public void update(Student stud){
        em.merge(stud);
    }
    
    @Override 
    @Transactional 
    public void deleteInstructorById(int id){
        Instructor ins = em.find(Instructor.class, id);
    
        // set associations to null
        List<Course> cs = ins.getCourses();
        for (Course c : cs) {
            c.setInstructor(null);
        }
    
        em.remove(ins);
    }
    
    @Override 
    @Transactional 
    public void deleteStudentById(int id) {
        Student stud = em.find(Student.class, id);
        
        if (stud != null) {
            List<Course> course = stud.getCourses();

            for (Course c : course) {
                c.getStudents().remove(stud);
            }
        }
        
        em.remove(stud);
    }
}
