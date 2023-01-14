package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.JpaWithHibernateApplication;
import com.studies.hibernate.jpawithhibernate.entity.course;
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



}