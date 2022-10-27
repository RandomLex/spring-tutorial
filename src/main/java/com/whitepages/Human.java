package com.whitepages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Human {
    @Value("1")
    private int id;
    @Value("Alex")
    private String name;
    @Autowired
    @My
    private Address address;

    public Human() {
        System.out.println();
    }


    public Human(@My Address address) {
        this.address = address;
    }

    public Human(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Autowired(required = false)
    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
