package com.barzykin.config;

import com.barzykin.model.Employee;
import com.barzykin.model.Group;
import com.barzykin.model.Mentor;
import com.barzykin.model.Student;
import com.barzykin.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan("com")
@PropertySource({"classpath:john.properties", "classpath:bob.properties", "classpath:teachers.properties"})
@EnableWebMvc
@EnableAspectJAutoProxy
public class JavaBasedConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(@Autowired ApplicationContext ctx) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setApplicationContext(ctx);
        resolver.setPrefix("/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Value("${john.id}")
    private int johnId;
    @Value("${john.name}")
    private String johnName;
    @Value("#{${john.marks}}")
    private Map<String, Integer> johnMarks;

    @Bean
    public Map<String, Integer> johnMarks() {
        return johnMarks;
    }

    @Bean
    public Map<String, Integer> bobMarks(@Value("#{${bob.marks}}") Map<String, Integer> marks) {
        return marks;
    }

    @Bean
    public Student john(@Autowired Map<String, Integer> johnMarks) {
        return new Student(johnId, johnName, johnMarks);
    }

    @Bean
    public Student bob(@Value("${bob.id}") int id,
                       @Value("${bob.name}") String name,
                       @Autowired Map<String, Integer> bobMarks) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setMarks(bobMarks);
        return student;
    }

    @Bean
    public Employee alex(@Value("${alex.id}") int id,
                         @Value("${alex.name}") String name,
                         @Value("${alex.salary}") int salary,
                         @Value("${alex.certs}") List<String> certificates) {
        Mentor alex = new Mentor(id, name, salary);
        alex.setCertificates(certificates);
        return alex;
    }

    @Bean
    public Employee anton() {
        Teacher anton = new Teacher(2, "Anton", 800);
        anton.setCertificates(List.of("Java", "JEE"));
        return anton;
    }

    @Bean
    public Group java(@Autowired Student john, @Autowired Student bob) {
        Group javaEe = new Group(1, "Java EE");
        javaEe.setStudents(List.of(john, bob));
        return javaEe;
    }


}
