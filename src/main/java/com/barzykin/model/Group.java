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
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Printing {
    private int id;
    private String name;
    // В конф. указан тип autowire byType. При этом название поля игорируется и спринг пытается найти любые бины,
    // совпадающие по типу или являющиеся наследниками указанного типа
    // А подсказать, какой бин мы имеем в виду, мы можем, указав его в аннотации @Qualifier("имя_бина")
    // и добавив аннотацию @Autowire над сеттером нужного поля. В современном спринге @Autowire можно не писать
    private Employee employee;
    private List<Student> students;

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
}
