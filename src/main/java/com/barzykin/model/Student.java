package com.barzykin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class Student extends Person {
    private Map<String, Integer> marks;

    public Student(int id, String name) {
        super(id, name);
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Student(int id, String name, Map<String, Integer> marks) {
        super(id, name);
        this.marks = marks;
    }

    public void initStudent() {
        System.out.println("Student has been created");
    }

    public void destroyStudent() {
        System.out.println("Student has been destroyed");
    }

}
