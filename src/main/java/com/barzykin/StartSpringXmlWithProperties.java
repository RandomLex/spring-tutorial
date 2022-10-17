package com.barzykin;

import com.barzykin.model.Group;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StartSpringXmlWithProperties {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-with-properties.xml");
        ctx.registerShutdownHook();

        Group java = ctx.getBean("java", Group.class);
        java.print();


    }
}
