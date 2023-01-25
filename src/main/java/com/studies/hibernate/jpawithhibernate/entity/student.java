package com.studies.hibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Annotation Type JoinTable. Specifies the mapping of associations. It is applied to the owning side of an association.
     * A join table is typically used in the mapping of many-to-many and unidirectional one-to-many associations.
     *
     * @JoinColumn is used to specify a column for joining an entity association or element collection.
     * This annotation indicates that the enclosing entity is the owner of the relationship and the corresponding table has a
     * foreign key column which references to the table of the non-owning sid
     *
     * InverseJoinColumn is used to customize the column name in the table of the associated class reference variable name.
     * that column act as a foreign key
     */
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name="STUDENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<course> course = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<com.studies.hibernate.jpawithhibernate.entity.course> getCourse() {
        return course;
    }

    public void setCourse(com.studies.hibernate.jpawithhibernate.entity.course course) {
        this.course.add(course);
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
