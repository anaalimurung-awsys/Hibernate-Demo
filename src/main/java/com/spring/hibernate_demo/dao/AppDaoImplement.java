package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository 
public class AppDaoImplement implements AppDao {
    
    private EntityManager em;

    public AppDaoImplement(EntityManager em) {
        this.em = em;
    }

    @Override 
    @Transactional 
    public void save(Instructor theTeacher) {
            em.persist(theTeacher);
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
}
