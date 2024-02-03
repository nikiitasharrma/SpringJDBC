package com.springjdbc.DatabaseConnection.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.DatabaseConnection.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
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

	
	@Override
	public Student selectStudent() {

		String query = "SELECT * FROM mytable WHERE id=?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student student = jdbcTemplate.queryForObject(query, rowMapper, this.student.getId());
		
		return student;
		
	}


	@Override
	public List<Student> selectAllStudents() {
		
		String query = "SELECT * FROM mytable";
		
		List<Student> students = jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
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
