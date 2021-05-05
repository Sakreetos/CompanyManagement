package com.company_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee extends Address {
    public String name;
    public int salary;
    public String sex;
    public int age;
    public int workingExperience;

    public Employee(String name, int salary, String country, String city, String street, int building, String sex, int age, int workingExperience) {
        super(country, city, street, building);
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.age = age;
        this.workingExperience = workingExperience;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getWorkingExperience() {
        return workingExperience;
    }

}
