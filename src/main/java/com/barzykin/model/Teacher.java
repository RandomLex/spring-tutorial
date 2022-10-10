package com.barzykin.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class Teacher extends Person {
    private int salary;

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
