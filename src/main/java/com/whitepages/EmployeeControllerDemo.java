package com.whitepages;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeControllerDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.whitepages");
        EmployeeController employeeController = ctx.getBean("employeesController", EmployeeController.class);
        employeeController.printEmployees();
    }
}
