package com.barzykin.config;

import com.barzykin.model.Employee;
import com.barzykin.model.Group;
import com.barzykin.model.Mentor;
import com.barzykin.model.Student;
import com.barzykin.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class JavaBasedConfiguration {

    @Bean
    public Map<String, Integer> johnMarks() {
        return Map.of("C", 8, "Python", 9, "Java", 10);
    }

    @Bean
    public Map<String, Integer> bobMarks() {
        return Map.of("C", 7, "Python", 8, "Java", 9);
    }

    @Bean
    public Student john(@Autowired Map<String, Integer> johnMarks) {
        return new Student(1, "John", johnMarks);
    }

    @Bean
    public Student bob(@Autowired Map<String, Integer> bobMarks) {
        Student student = new Student();
        student.setId(2);
        student.setName("Bob");
        student.setMarks(bobMarks);
        return student;
    }

    @Bean
    public Employee alex() {
        Mentor alex = new Mentor(1, "Alex", 1000);
        alex.setCertificates(List.of("Java", "AWS", "Cisco"));
        return alex;
    }

    @Bean
    public Employee anton() {
        Teacher alex = new Teacher(2, "Anton", 800);
        alex.setCertificates(List.of("Java", "JEE"));
        return alex;
    }

    @Bean
    public Group java(@Autowired Employee alex, @Autowired Student john, @Autowired Student bob) {
        Group javaEe = new Group(1, "Java EE", alex, List.of(john, bob));
        return javaEe;
    }


}
