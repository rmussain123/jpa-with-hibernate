package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@NamedQuery(name="course.passport", query="SELECT id, number FROM passport")
public class passport {


    @Id
    @GeneratedValue
    private int id;

    /**
     * JPA Provide column annotation with nullable which will check null internally and not allow null value
     */
    @Column(nullable = false)
    private String number;

    protected passport(){

    }
    public passport(String number) {
        this.number = number;
    }

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private student student;

    public com.studies.hibernate.jpawithhibernate.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.studies.hibernate.jpawithhibernate.entity.student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "passport{" +
                "number='" + number + '\'' +
                '}';
    }
}
