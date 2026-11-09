package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Instructor;
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
}
