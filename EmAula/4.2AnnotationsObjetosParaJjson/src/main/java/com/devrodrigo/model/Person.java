package com.devrodrigo.model;

import com.devrodrigo.annotation.SerializeMethod;
import com.devrodrigo.annotation.SerializerType;

import static com.devrodrigo.annotation.FieldFormatEnum.CAMEL_CASE;
import static com.devrodrigo.annotation.FieldFormatEnum.KEBAB_CASE;

@SerializerType(fieldFormat = CAMEL_CASE, prettify = true)
public class Person {
    private long id;
    private String name;
    private int age;


    public Person(){}

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @SerializeMethod("firstPersonName")
    public String firstName(){
        return name.split(" ")[0];
    }
}
