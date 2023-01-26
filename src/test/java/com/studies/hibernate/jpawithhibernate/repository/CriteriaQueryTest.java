package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.JpaWithHibernateApplication;
import com.studies.hibernate.jpawithhibernate.entity.course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
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
class CriteriaQueryTest {

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
        logger.info("Tets is running");
    }

    /**
     * Using criteria builder example demo
     */
    @Test
    public void cb_basic(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(course.class);

        Root<course> courseRoot = cq.from(course.class);
        TypedQuery<course> tq= entityManager.createQuery(cq.select(courseRoot));

        logger.info("Typed query result set {}", tq.getResultList());
    }

    /**
     * Using criteria builder example demo with like
     */

    @Test
    public void cb_with_like(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(course.class);

        Root<course> courseRoot = cq.from(course.class);

        //Use the object of criteria builder here and assign this with Predicate object
        Predicate coursePredicate = cb.like(courseRoot.get("Name"), "%Spring%");

        //Assign Predicate example with query object
        cq.where(coursePredicate);

        TypedQuery<course> tq= entityManager.createQuery(cq.select(courseRoot));

        logger.info("Typed query result set of like {}", tq.getResultList());
    }


    @Test
    public void cb_without_student(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(course.class);

        Root<course> courseRoot = cq.from(course.class);

        //using predicate to get the objects of many to many
        Predicate coursePredicate = cb.isEmpty(courseRoot.get("students"));

        //Assign Predicate example with query object
        cq.where(coursePredicate);

        TypedQuery<course> tq= entityManager.createQuery(cq.select(courseRoot));

        logger.info("Typed query result set of without students {}", tq.getResultList());
    }

    @Test
    public void cb_with_joins(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(course.class);

        Root<course> courseRoot = cq.from(course.class);


        //using join in criteria builder
        courseRoot.join("students", JoinType.RIGHT);

        //using predicate to get the objects of many to many
//        Predicate coursePredicate = cb.isEmpty(courseRoot.get("students"));

        //Assign Predicate example with query object
//        cq.where(coursePredicate);

        TypedQuery<course> tq= entityManager.createQuery(cq.select(courseRoot));

        logger.info("coursePredicate examples with joins {}", tq.getResultList());
    }
}