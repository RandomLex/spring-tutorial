package com.barzykin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public abstract class Person implements Printing {
    @Value("1")
    protected int id;
    @Value("John")
    protected String name;
}
