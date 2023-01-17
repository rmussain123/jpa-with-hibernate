package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.entity.course;
import com.studies.hibernate.jpawithhibernate.entity.passport;
import com.studies.hibernate.jpawithhibernate.entity.review;
import com.studies.hibernate.jpawithhibernate.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(CourseRepository.class);

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


    public void playWithEMFlushClear(){
        course course = new course("Learn hibernate ex-1");
        em.persist(course);
        em.flush();
        course course1 = new course("Learn hibernate ex-2");
        em.persist( course1);
        em.flush();

        //This method will clear all the things which em manages
        em.clear();

         /*This method with discontinued the conenctivity with database object to be updated so that upcoming changes will not
         * track to update in the database*/
        em.detach(course);

        course.setName("Learn hibernate ex-1 - updated");

        //This method will force to update the value to the database..
        em.flush();



        course1.setName("Learn hibernate ex-2 - Updated");

    }

    /**
     * em.refresh -  This method will refresh the value with database value
     * This method will remove the value which already has been set and take the value from database..
     */

    public void playWithEMFlushRfresh(){
        course course = new course("Learn hibernate ex-1");
        em.persist(course);

        course course1 = new course("Learn hibernate ex-2");
        em.persist( course1);
        em.flush();

        course.setName("Learn hibernate ex-1 - updated");
        course1.setName("Learn hibernate ex-2 - Updated");
        em.refresh(course);
        System.out.println("The name value ::" + course.getName());


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

    public List<passport> getAllPassport(){

        List<passport> passports = em.createNamedQuery("course.passport").getResultList();
        return passports;

    }


    public List<review> getAllReview(){

        List<review> reviews = em.createNamedQuery("course.review").getResultList();
        return reviews;

    }


    public List<student> getAllStudent(){

        List<student> students = em.createNamedQuery("course.student").getResultList();
        return students;

    }

    public void addReviewForCourse(){
        course course= findById(10003L);
        logger.info("Inside Add review for courses {}", course.getReviews());
        review review1 = new review("5", "Great handon");
        review review2 = new review("5", "Hats - Off");

        course.addReview(review1);
        course.addReview(review2);

        review1.setCourse(course);
        review2.setCourse(course);
        em.persist(review1);
        em.persist(review2);

    }




    //public Course findById(LongId)
    //public Course save(Course course)  -> insert or update
}
