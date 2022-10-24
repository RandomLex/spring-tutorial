package com.barzykin;

import com.barzykin.model.Group;
import com.barzykin.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StartSpringOnlyAnnotations {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com");

//        ctx.registerShutdownHook();

        Group java = ctx.getBean("java", Group.class);
        java.print();




    }
}
