package com.devrodrigo;

import com.devrodrigo.model.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("inicio");
        var person = new PersonBuilder()
                .id(1)
                .name("Rodrigo")
                .build();
        System.out.println(person);
    }
}
