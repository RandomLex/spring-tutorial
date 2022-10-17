package com.barzykin.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class Teacher extends Person {
    private int salary;
    private List<String> certificates;

    public Teacher(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    public void init() {
        System.out.println(Thread.currentThread().getName() + ": Teacher has been created");
    }

    public void destroy() {
        System.out.println(Thread.currentThread().getName() + ": Teacher has been destroyed");
    }

    public void initTeacher() {
        System.out.println(Thread.currentThread().getName() + ": Teacher has been created - individual");
    }

    public void destroyTeacher() {
        System.out.println(Thread.currentThread().getName() + ": Teacher has been destroyed - individual");
    }

}
