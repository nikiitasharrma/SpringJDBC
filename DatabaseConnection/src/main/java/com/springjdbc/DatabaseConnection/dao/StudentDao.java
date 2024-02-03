package com.springjdbc.DatabaseConnection.dao;

import java.util.List;

import com.springjdbc.DatabaseConnection.entity.Student;

public interface StudentDao {
	
	int insert();
	
	int update();
	
	int delete();
	
	Student selectStudent();
	
	List<Student> selectAllStudents();
	
}
