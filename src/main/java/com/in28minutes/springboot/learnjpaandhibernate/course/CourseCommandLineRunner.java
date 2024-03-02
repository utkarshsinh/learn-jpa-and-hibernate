package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

//When we have some logic to run in the start of the application
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		repository.insert(new Course(1, "Learn AWS JPA!", "in28minutes"));
//		repository.insert(new Course(2, "Learn GCP JPA!", "in28minutes"));
//		repository.insert(new Course(3, "Learn AZURE JPA!", "in28minutes"));
//		
//		repository.delete(2);
//		
//		System.out.println(repository.select(3));
		
		repository.save(new Course(1, "Learn AWS spring-JPA!", "in28minutes"));
		repository.save(new Course(2, "Learn GCP spring-JPA!", "in28minutes"));
		repository.save(new Course(3, "Learn AZURE spring-JPA!", "in28minutes"));
		
		repository.deleteById(2l);
		
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		
		System.out.println(repository.findByAuthor("in28minutes"));
		
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn AWS spring-JPA!"));
		
		System.out.println(repository.findByName(""));
		
		
		
	}

}
