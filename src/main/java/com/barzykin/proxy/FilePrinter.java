package com.barzykin.proxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinter implements Printer {

    @Override
    public void print(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            // do nothing
        }
    }
}
