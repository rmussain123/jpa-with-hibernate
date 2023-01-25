package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<review> reviews = new ArrayList<>();


    @ManyToMany(mappedBy = "course")
    private List<student> students = new ArrayList<>();

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

    public List<review> getReviews() {
        return reviews;
    }

    public void addReview(review review) {
        this.reviews.add(review);
    }

    public void removeReview(review review) {
        this.reviews.remove(review);
    }

    public List<student> getStudents() {
        return students;
    }

    public void addStudent(student students) {
        this.students.add(students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
