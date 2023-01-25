package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.entity.*;
import com.studies.hibernate.jpawithhibernate.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;


    public student findById(Long id){

        return em.find(student.class, id);
    }

    public student save(student student){
        if(student.getId() == 0){
            em.persist(student);
        }else{
            em.merge(student);
        }
        return student;
    }
    public void deletById(Long id){

        student student = em.find(com.studies.hibernate.jpawithhibernate.entity.student.class, id);
        em.remove(student);
    }

    /**
     * In this example you can notice that, after data update completion
     * if anything has been modified the attribute @Transaction attribute will keep tracking that values and update the same in
     * database.
     * When I ran this method  name has been updated even after the persist method ran. This is taking care by transactional annotation
     */
    public void playWithEntityManager(){
        student student = new student("This is playing insert");
        em.persist(student);
        student.setName("This is playing update!");
    }


    public void playWithEMFlushClear(){
        student student = new student("Learn hibernate ex-1");
        em.persist(student);
        em.flush();
        student student1 = new student("Learn hibernate ex-2");
        em.persist( student1);
        em.flush();

        //This method will clear all the things which em manages
        em.clear();

         /*This method with discontinued the conenctivity with database object to be updated so that upcoming changes will not
         * track to update in the database*/
        em.detach(student);

        student.setName("Learn hibernate ex-1 - updated");

        //This method will force to update the value to the database..
        em.flush();



        student1.setName("Learn hibernate ex-2 - Updated");

    }

    /**
     * em.refresh -  This method will refresh the value with database value
     * This method will remove the value which already has been set and take the value from database..
     */

    public void playWithEMFlushRfresh(){
        student student = new student("Learn hibernate ex-1");
        em.persist(student);

        student student1 = new student("Learn hibernate ex-2");
        em.persist( student1);
        em.flush();

        student.setName("Learn hibernate ex-1 - updated");
        student1.setName("Learn hibernate ex-2 - Updated");
        em.refresh(student);
        System.out.println("The name value ::" + student.getName());


    }

    public void saveStudentDetails(){
        passport passport = new passport("Z12345");
        em.persist(passport);
        student student = new student("Mike");
        student.setPassport(passport);
        em.persist(student);

    }

    /**
     * Getting all record using entity manager
     * Here the student.findall will be mapping in student pojo class
     * This will be fetching from there
     */

    public List<student> getAllstudents(){

        List<student> students = em.createNamedQuery("student.findAll").getResultList();
        return students;

    }

    public List<passport> getAllPassport(){

        List<passport> passports = em.createNamedQuery("student.passport").getResultList();
        return passports;

    }


    public List<review> getAllReview(){

        List<review> reviews = em.createNamedQuery("student.review").getResultList();
        return reviews;

    }


    public List<student> getAllStudent(){

        List<student> students = em.createNamedQuery("student.student").getResultList();
        return students;

    }

    public void saveStudentCourseDetails(student student , course course){
        student.setCourse(course);
        course.addStudent(student);
       em.persist(student);
        em.persist(course);

    }


    //public student findById(LongId)
    //public student save(student student)  -> insert or update
}
