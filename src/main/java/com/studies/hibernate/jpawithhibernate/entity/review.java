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
    public review(String description) {
        this.description = description;
    }

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

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

    @Override
    public String toString() {
        return "review{" +
                "rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
