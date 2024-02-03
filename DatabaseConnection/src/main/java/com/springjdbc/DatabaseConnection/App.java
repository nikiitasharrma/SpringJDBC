package com.springjdbc.DatabaseConnection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springjdbc.DatabaseConnection.dao.StudentDao;
import com.springjdbc.DatabaseConnection.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/DatabaseConnection/jdbcConfig.xml");
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
//        int result = studentDao.insert();
        
//        int result = studentDao.update();
        
//        int result = studentDao.delete();
        
        Student student = studentDao.selectStudent();
        
//        System.out.println("Number of rows affected: " + result);
        System.out.println(student);
    }
}
