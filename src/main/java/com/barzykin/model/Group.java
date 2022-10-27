package com.barzykin.model;

import com.barzykin.model.qualifiers.MentorQualifier;
import com.barzykin.model.qualifiers.TeacherQualifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("classpath:group.properties")
@Component
public class Group implements Printing {
    @Value("${group.java.id}")
    private int id;
    @Value("${group.java.name}")
    private String name;

    //Использование @Value перезатирает предыдущее внедрение (injection) бина alex (см. JavaBasedConfiguration класс), потому, что в
    // жизненном цикле бина установка @Value происходит позже.
    //    @Value("#{group.java.employee}")
    @Autowired
    @ToString.Exclude
    private Map<String, Employee> employeeMap;

    @Value("${group.java.employee}")
    @ToString.Exclude
    private String employeeBeanName;

    private Employee employee;
    private List<Student> students;


    @PostConstruct
    private void init() {
        this.employee = employeeMap.get(employeeBeanName);
    }

    public Group(int id, String  name) {
        this.id = id;
        this.name = name;
    }

    public Group(int id, String  name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void printEmployees() {
        System.out.println(employeeMap);
    }
}
