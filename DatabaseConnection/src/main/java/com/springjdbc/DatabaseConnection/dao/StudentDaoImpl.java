package com.springjdbc.DatabaseConnection.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.DatabaseConnection.entity.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private Student student;

	@Override
	public int insert() {
		
		String query = "INSERT INTO mytable VALUES(?,?)";
		
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName());
		
		return r;
	}
	

	@Override
	public int update() {
		
		String query = "UPDATE mytable SET name=? WHERE id=?";
		
		int r = jdbcTemplate.update(query,student.getName(),student.getId());
		
		return r;
	}

	@Override
	public int delete() {

		String query = "DELETE FROM mytable WHERE id=?";
		
		int r = jdbcTemplate.update(query,student.getId());
		
		return r;
	}

	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
