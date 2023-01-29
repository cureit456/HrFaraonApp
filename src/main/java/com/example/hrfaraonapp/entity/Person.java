package com.example.hrfaraonapp.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleDoubleProperty salary;
    private SimpleStringProperty experience;

    public Person(String firstName, String lastName, Double salary, String experience) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName =  new SimpleStringProperty(lastName);
        this.salary = new SimpleDoubleProperty(salary);
        this.experience = new SimpleStringProperty(experience);
    }
    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public double getSalary() {
        return salary.get();
    }

    public SimpleDoubleProperty salaryProperty() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public String getExperience() {
        return experience.get();
    }

    public SimpleStringProperty experienceProperty() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience.set(experience);
    }
}
