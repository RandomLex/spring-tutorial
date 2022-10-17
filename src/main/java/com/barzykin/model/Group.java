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
    // В конф. указан тип autowire byType. При этом название поля игорируется и спринг пытается найти любые бины,
    // совпадающие по типу или являющиеся наследниками указанного типа
    private Teacher teacher;
    private List<Student> students;

    public Group(int id, String  name) {
        this.id = id;
        this.name = name;
    }

}
