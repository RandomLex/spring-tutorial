package com.barzykin.config;

import com.barzykin.model.Employee;
import com.barzykin.model.Group;
import com.barzykin.model.Student;
import com.barzykin.model.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class JavaBasedConfiguration {
    @Bean
    public Student john() {
        return new Student(1, "John", Map.of("C", 8, "Python", 9, "Java", 10));
    }

    @Bean
    public Student bob() {
        Student student = new Student();
        student.setId(2);
        student.setName("Bob");
        student.setMarks(Map.of("C", 7, "Python", 8, "Java", 9));
        return student;
    }

    @Bean
    public Employee alex() {
        Teacher alex = new Teacher(1, "Alex", 1000);
        alex.setCertificates(List.of("Java", "AWS", "Cisco"));
        return alex;
    }

    @Bean
    public Group java() {
        Group javaEe = new Group(1, "Java EE", alex(), List.of(john(), bob()));
        return javaEe;
    }


}
