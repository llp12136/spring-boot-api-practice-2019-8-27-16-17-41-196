package com.tw.apistackbase.entity;

public class Company {
    String id;
    String name;

    public Company() {
    }

    public Company(String id,String name) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
