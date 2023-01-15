package com.studies.hibernate.jpawithhibernate;

import com.google.gson.Gson;
import com.studies.hibernate.jpawithhibernate.repository.CourseRepository;
import com.studies.hibernate.jpawithhibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner {


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
//		courseRepository.deletById(10001L);
//		courseRepository.save(new Course("Sonata"));

//		studentRepository.saveStudentDetails();
		Gson json = new Gson();
		logger.info("Course details::"+json.toJson(courseRepository.getAllCourses()));
		logger.info("Passport details::"+json.toJson(courseRepository.getAllPassport()));
		logger.info("Review details::"+json.toJson(courseRepository.getAllReview()));
		logger.info("students details::"+json.toJson(courseRepository.getAllStudent()));

	}
}
