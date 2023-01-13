package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name="course.findAll", query="SELECT id, Name FROM course")
public class course {

    @Id
    @GeneratedValue
    private int id;

    private String Name;

    protected course(){

    }
    public course(String name) {
        Name = name;
    }

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
