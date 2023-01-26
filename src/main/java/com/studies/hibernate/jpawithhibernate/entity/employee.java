package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//@MappedSuperclass  //separate tables will be created for inherited class, No relationship between subcalss and super class
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // SINGLE_TABLE is used by default itself
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //Table per class have each concrete class will have its own table
@Inheritance(strategy=InheritanceType.JOINED)
 //@DiscriminatorColumn(name = "Employee_TYPE") // To provide name inherited attributes
public abstract class employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    protected employee() {
    }

    public employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Employee[%s]", name);
    }
}