package com.devrodrigo.model;

import com.devrodrigo.annotation.SerializerType;

import static com.devrodrigo.annotation.FieldFormatEnum.PASCAL_CASE;
import static com.devrodrigo.annotation.FieldFormatEnum.SNAKE_CASE;

@SerializerType(fieldFormat = PASCAL_CASE, prettify = true)
public record User (
//public class User {
    long id,
//    private long id;
    String fullName,
//    private String fullName;
    int age,
//    private int age;
    double salary
//    private double salary;

//    public User(){}
//
//    public User(long id, String fullName, int age, double salary) {
//        this.id = id;
//        this.fullName = fullName;
//        this.age = age;
//        this.salary = salary;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
){}
