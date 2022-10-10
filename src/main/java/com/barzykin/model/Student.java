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
public class Student extends Person {
    private List<Integer> marks;

    public Student(int id, String name, List<Integer> marks) {
        super(id, name);
        this.marks = marks;
    }

}
