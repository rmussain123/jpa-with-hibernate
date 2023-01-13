package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.entity.course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;


    public course findById(Long id){

        return em.find(course.class, id);
    }

    public course save(course course){
        if(course.getId() == 0){
            em.persist(course);
        }else{
            em.merge(course);
        }
        return course;
    }
    public void deletById(Long id){

        course course = em.find(com.studies.hibernate.jpawithhibernate.entity.course.class, id);
        em.remove(course);
    }

    /**
     * In this example you can notice that, after data update completion
     * if anything has been modified the attribute @Transaction attribute will keep tracking that values and update the same in
     * database.
     * When I ran this method  name has been updated even after the persist method ran. This is taking care by transactional annotation
     */
    public void playWithEntityManager(){
        course course = new course("This is playing insert");
        em.persist(course);
        course.setName("This is playing update!");
    }

    /**
     * Getting all record using entity manager
     * Here the course.findall will be mapping in course pojo class
     * This will be fetching from there
     */

    public List<course> getAllCourses(){

        List<course> courses = em.createNamedQuery("course.findAll").getResultList();
        return courses;

    }


    //public Course findById(LongId)
    //public Course save(Course course)  -> insert or update
}
