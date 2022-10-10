package com.barzykin.model;

public interface Printing {
    default void print() {
        System.out.println(this);
    }
}
