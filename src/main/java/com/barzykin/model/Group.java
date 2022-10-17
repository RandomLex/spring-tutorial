package com.barzykin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Printing {
    private int id;
    private String name;
    //В качестве названия поля мы используем название бина. При этом в конф. указан тип autowire byName
    private Teacher alex;
    private List<Student> students;

    public Group(int id, String  name) {
        this.id = id;
        this.name = name;
    }

}
