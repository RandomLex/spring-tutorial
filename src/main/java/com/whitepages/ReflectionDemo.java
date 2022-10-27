package com.whitepages;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectionDemo {
    public static void main(String[] args) {
        Address ivanAddress = new Address("Minsk", "Pushkina", "2", "3");
        Human ivan = new Human();
        ivan.setName("Ivan");
        Human petr = new Human();
        Class<Human> humanClass = Human.class;
        for (Annotation annotation : humanClass.getAnnotations()) {
            System.out.println(annotation);
        }


        for (Field declaredField : humanClass.getDeclaredFields()) {
            System.out.println(declaredField.getName());
        }

        try {
            Field fieldName = humanClass.getDeclaredField("name");
            fieldName.setAccessible(true);

            Field addressField = humanClass.getDeclaredField("address");
            fieldName.set(ivan, "Ваня");
            addressField.set(ivan, ivanAddress);
            addressField.setAccessible(true);



            for (Annotation annotation : addressField.getAnnotations()) {
                System.out.println(annotation);
            }


            String name  = (String) fieldName.get(ivan);
            System.out.println(name);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        System.out.println(ivan);
    }
}
