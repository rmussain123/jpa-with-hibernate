package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


//@NamedQueries(value = {
//        @NamedQuery(name="findAll", query="SELECT id, Name FROM course"),
//        @NamedQuery(name="findid", query="SELECT id FROM course")}
//)

@Entity
@NamedQuery(name="course.findAll", query="SELECT id, Name FROM course")
public class course {

    @Id
    @GeneratedValue
    private int id;

    /**
     * JPA Provide column annotation with nullable which will check null internally and not allow null value
     */
    @Column(nullable = false)
    private String Name;

    protected course(){

    }
    public course(String name) {
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
        return "Course{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
