package com.tw.apistackbase.entity;

import java.util.List;

public class Company {
    String id;
    String name;
    List<Employee> employees ;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company() {
    }

    public Company(String id,String name) {
        this.name = name;
        this.id = id;
        //this.employees = employees;
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
