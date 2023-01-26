package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.JpaWithHibernateApplication;
import com.studies.hibernate.jpawithhibernate.entity.course;
import com.studies.hibernate.jpawithhibernate.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * This test class is describing to query from JPA pojo and not from database
 */

@SpringBootTest(classes = JpaWithHibernateApplication.class)
class JPATest {

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
        logger.info("Tets is running");
    }

    /**
     * Generic query to fetch the all course values
     */
    @Test
    public void Jpql_basic(){
        Query query = entityManager.createQuery("select c from course c");
        List resultList = query.getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    /**
     * Query using Typed query
     */

    @Test
    public void Jpql_withTyped(){
        TypedQuery<course> query = entityManager.createQuery("select c from course c", course.class);
        List resultList = query.getResultList();
        logger.info("select c from Course with typed -> {}", resultList);
    }

    /**
     * Query with where condition
     */
    @Test
    public void Jpql_withWhere(){
        TypedQuery<course> query = entityManager.createQuery("select c from course c where Name like '%Learn hibernate ex-1%'", course.class);
        List resultList = query.getResultList();
        logger.info("select c from Course with where condition -> {}", resultList);
    }

    /**
     * In this example the students has been referred from the entity class manytomany which we defined.
     * Here students no need to refer the table which is created
     */
    @Test
    public void Jpql_courses_without_students(){
        TypedQuery<course> query = entityManager.createQuery("select c from course c where c.students is empty", course.class);
        List resultList = query.getResultList();
        logger.info("select c from Course with where condition -> {}", resultList);
    }

    /**
     * JPQL Example query with size more than 2
     */

    @Test
    public void Jpql_courses_more_than_2_students(){
        TypedQuery<course> query = entityManager.createQuery("select c from course c where size(c.students) >= 2", course.class);
        List resultList = query.getResultList();
        logger.info("select c from Course with where more than 2 students -> {}", resultList);
    }

    /**
     * JPQL Example with ordrr by example
     */
    @Test
    public void Jpql_courses_more_odered_by_students(){
        TypedQuery<course> query = entityManager.createQuery("select c from course c order by size(c.students) ", course.class);
        List resultList = query.getResultList();
        logger.info("select c from Course with order by size of 2 students -> {}", resultList);
    }


    @Test
    public void Jpql_courses_with_with_passports_in_a_certain_pattern(){
        TypedQuery<student> query = entityManager.createQuery("select s from student s where s.passport.id like '%12%' ", student.class);
        List resultList = query.getResultList();
        logger.info("Student passport results -> {}", resultList);
    }


}