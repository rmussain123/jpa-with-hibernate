package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NamedQuery(name="course.student", query="SELECT id, Name FROM student")
public class student {

    @Id
    @GeneratedValue
    private int id;

    /**
     * JPA Provide column annotation with nullable which will check null internally and not allow null value
     */
    @Column(nullable = false)
    private String Name;

    /**
     * Unnecessary the data will fetch if we use fetch type as eager.
     * If we use here as LAZY as fetch type, this will fetch only the lazy type
     * See the logger
     */
    @OneToOne(fetch = FetchType.LAZY)
    private passport passport;


    public com.studies.hibernate.jpawithhibernate.entity.passport getPassport() {
        return passport;
    }

    public void setPassport(com.studies.hibernate.jpawithhibernate.entity.passport passport) {
        this.passport = passport;
    }


    protected student(){

    }
    public student(String name) {
        Name = name;
    }

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
