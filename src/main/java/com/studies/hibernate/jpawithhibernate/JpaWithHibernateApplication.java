package com.studies.hibernate.jpawithhibernate;

import com.studies.hibernate.jpawithhibernate.entity.Person;
import com.studies.hibernate.jpawithhibernate.jdbc.PersonJdbcDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;


	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Jpa for database {}"+dao.findAll());
		logger.info("Jpa for for the single object {}"+dao.findById(10003));
//		logger.info("Jpa for for the deleteing object {}"+dao.deleteById(10002));

		logger.info("Value has been inserted::::"+dao.insert(
				new Person(10002,"Hussain", "Chennai", Date.valueOf("2023-01-07"))));

		logger.info("Value has been updated::::"+dao.update(
				new Person(10002,"Hussain123", "", null)));
	}
}
