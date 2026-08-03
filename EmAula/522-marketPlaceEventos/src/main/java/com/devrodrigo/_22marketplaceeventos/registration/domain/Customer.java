package com.devrodrigo._22marketplaceeventos.registration.domain;

import org.springframework.util.Assert;

public class Customer {
    private CustomerId id;
    private String name;
    private String email;

    public Customer(CustomerId id, String name, String email) {
        Assert.notNull(name, "Nome não pode ficar vazio");
        Assert.notNull(email, "E-mail não pode ficar vazio");
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer(String name, String email) {
        this(new CustomerId(), name, email);
    }

    public CustomerId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
