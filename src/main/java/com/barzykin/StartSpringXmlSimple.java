package com.barzykin;

import com.barzykin.model.Group;
import com.barzykin.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartSpringXmlSimple {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.registerShutdownHook();
//        Student john = ctx.getBean("john", Student.class);
//        Student bob = ctx.getBean("bob", Student.class);
//
//        john.print();
//        bob.print();

        Group java = ctx.getBean("java", Group.class);
        java.print();
        Student anna = java.getStudents().get(2);
        anna.print();

        if (true) {
            throw new RuntimeException();
        }

    }
}
