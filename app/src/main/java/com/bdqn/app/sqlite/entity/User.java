package com.bdqn.app.sqlite.entity;

/**
 * Created by teng on 2016/5/17.
 */
public class User {
    public String name;
    public int age;
    public String address;

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
