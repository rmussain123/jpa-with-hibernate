package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){

        return em.find(Course.class, id);
    }

    public Course save(Course course){
        if(course.getId() == 0){
            em.persist(course);
        }else{
            em.merge(course);
        }
        return course;
    }
    public void deletById(Long id){

        Course course = em.find(Course.class, id);
        em.remove(course);
    }


    //public Course findById(LongId)
    //public Course save(Course course)  -> insert or update
}
