package com.spring.hibernate_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Review class.
 */
@Entity
public class Review {
    
    @Id 
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="comments")
    private String comments;

    /**
     * Non-parameterized constructor.
     */
    public Review() {
    }

    /**
     * Parametized constructor for Review.
     * @param comments
     */
    public Review(String comments) {
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Review [comments=" + comments + "\n]";
    }
}
