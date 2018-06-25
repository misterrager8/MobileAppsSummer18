package com.example.chemlleijoseph.myapplication.bean;

import java.io.Serializable;

public class Base implements Serializable {

    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Base{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
