package com.whitepages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
    @Value("Homel")
    private String city;
    @Value("Kozhara")
    private String street;
    @Value("1")
    private String home;
    @Value("57")
    private String room;

    @Autowired
    public Address() {
    }

    public Address(String city, String street, String home, String room) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.room = room;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHome() {
        return home;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
