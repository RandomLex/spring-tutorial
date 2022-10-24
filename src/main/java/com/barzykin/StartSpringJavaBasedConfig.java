package com.barzykin;

import com.barzykin.model.Group;
import com.barzykin.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StartSpringJavaBasedConfig {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com");

        Group java = ctx.getBean("java", Group.class);
        java.print();

//        Student john = ctx.getBean("john", Student.class);
//        john.print();


    }
}
