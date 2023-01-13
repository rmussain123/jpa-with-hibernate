package com.studies.hibernate.jpawithhibernate.repository;

import com.studies.hibernate.jpawithhibernate.JpaWithHibernateApplication;
import com.studies.hibernate.jpawithhibernate.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest(classes = JpaWithHibernateApplication.class)
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
        logger.info("Tets is running");
    }

    @Test
    public void findById_basic(){
        Course course = courseRepository.findById(10001L);
        Assertions.assertEquals("JPA in 50 steps" , course.getName());
    }

    @Test
    public void insertRecordTest(){
        Course course = courseRepository.findById(10002L);
        course.setName("JPA Learned");
        courseRepository.save(course);
        Course course1 = courseRepository.findById(10002L);
        Assertions.assertEquals("JPA Learned" , course1.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic(){
        courseRepository.deletById(10002L);
        Assertions.assertNull(courseRepository.findById(10002L));
    }

}