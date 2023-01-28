package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.JpaWithHibernateApplication;
import com.studies.hibernate.jpawithhibernate.entity.course;
import com.studies.hibernate.jpawithhibernate.entity.review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Optional;


@SpringBootTest(classes = JpaWithHibernateApplication.class)
class SpringCourseRepositoryTest {

    @Autowired
    SpringCourseDataRepository courseRepository;

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
        logger.info("Tets is running");
    }

    @Test
    @Transactional
    public void retrieveCourse(){

        Optional<course> courseOptional = courseRepository.findById(10001);

        logger.info("This is JPA Repository value {}",courseOptional.get().getStudents());

    }

    /**
     * In this example we can test the pagination using JPA repository
     */
    @Test
    @Transactional
    public void retrieveCourseWithPagination(){

        PageRequest pageRequest = PageRequest.of(0,3);
        Page<course> firstPage = courseRepository.findAll(pageRequest);
        logger.info("First page -> {}", firstPage.getContent());

        Pageable secondPageble = firstPage.nextPageable();
        Page<course> secondPage = courseRepository.findAll(secondPageble);

        logger.info("Second page -> {}", secondPage.getContent());

    }

    @Test
    @Transactional
    public void retrieveCourseWithNoStudents(){
        Optional<course> courseOptional = courseRepository.findById(20001);

        Assertions.assertFalse(courseOptional.get().getStudents().isEmpty());

    }

}