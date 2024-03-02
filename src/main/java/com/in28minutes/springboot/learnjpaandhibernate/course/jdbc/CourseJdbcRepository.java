package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			
			"""
				INSERT INTO COURSE (ID, NAME, AUTHOR)

				VALUES(?, ?, ?)
				
			""";
	
	private static String DELETE_QUERY = 
			"""
				DELETE from COURSE where ID=?
			
			""";
	
	private static String SELECT_QUERY = 
			"""
				SELECT * from COURSE where ID=?
			
			""";
//	Order should be same as question mark
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course select(long id) {
		// TODO Auto-generated method stub
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class), id);
		//ResultSet -> Bean -> Row Mapped
	}

	
}
