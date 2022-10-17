package com.barzykin.model;

import com.barzykin.model.qualifiers.AlexQualifier;
import com.barzykin.model.qualifiers.AntonQualifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
    private Teacher teacher;
    private List<Student> students;

    public Group(int id, String  name) {
        this.id = id;
        this.name = name;
    }

    @Autowired
    @AlexQualifier
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
