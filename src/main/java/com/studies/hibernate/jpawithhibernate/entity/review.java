package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@NamedQuery(name="course.review", query="SELECT rating, description FROM review")
public class review {

    @Id
    @GeneratedValue
    private int id;

    /**
     * JPA Provide column annotation with nullable which will check null internally and not allow null value
     */

    private String rating;

    private String description;

    protected review(){

    }
    public review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @ManyToOne
    private course course;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public com.studies.hibernate.jpawithhibernate.entity.course getCourse() {
        return course;
    }

    public void setCourse(com.studies.hibernate.jpawithhibernate.entity.course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "review{" +
                "rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
