/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//import com.mycompany.dao.HelloWorldConfig;
//import com.mycompany.dao.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author W208412665
 */
public class AppMain {

    public static void main(String args[]) {
        // AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        // HelloWorld bean = (HelloWorld) context.getBean("helloWorldBean");
        // bean.sayHello("Spring 4");
        // context.close();

        //AbstractApplicationContext context = new ClassPathXmlApplicationContext("helloworld-config.xml");
        // Person person = (Person) context.getBean("person");
        //System.out.println(person);
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Spring-DAO.xml");
        StudentsDAO studentsDao = (StudentsDAO) context.getBean("studentDao");

        Students student = new Students();
        student.setFirstname("Test FName");
        student.setLastname("Test LName");
        student.setAddress("Test Address");

        try {

            studentsDao.persist(student);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
