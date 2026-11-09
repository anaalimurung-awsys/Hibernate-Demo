package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
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

        em.remove(ins);
    }

    @Override 
    @Transactional 
    public void deleteInstructorDetailById(int id){
        InstructorDetail info = em.find(InstructorDetail.class, id);

        info.getInstructor().setInstructorInfo(null);
        em.remove(info);
    }
}
