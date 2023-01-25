package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.JpaWithHibernateApplication;
import com.studies.hibernate.jpawithhibernate.entity.course;
import com.studies.hibernate.jpawithhibernate.entity.passport;
import com.studies.hibernate.jpawithhibernate.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest(classes = JpaWithHibernateApplication.class)
class studentRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
        logger.info("Tets is running");
    }

    @Test
    @Transactional
    public void findById_basic(){
        student student = entityManager.find(com.studies.hibernate.jpawithhibernate.entity.student.class,1);
        logger.info("student -> {}", student);
        logger.info("student -> {}", student.getPassport());

    }

    @Test
    @Transactional
    public void findByStudent_basic(){
        passport passport = entityManager.find(com.studies.hibernate.jpawithhibernate.entity.passport.class,40001l);
        logger.info("passport -> {}", passport);
        logger.info("passport -> {}", passport.getStudent());

    }

    @Test
    @Transactional
    public void findByStudent_join(){
        student student = entityManager.find(com.studies.hibernate.jpawithhibernate.entity.student.class,20001L);
        logger.info("student id -> {}", student.getId());
        logger.info("student courses -> {}", student.getCourse());

    }



}