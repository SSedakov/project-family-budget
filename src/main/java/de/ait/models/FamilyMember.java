package de.ait.models;

import java.util.UUID;

public class FamilyMember {
    private String firstName;
    private String lastName;
    private int age;
    private String status;
    private int salary;
    private String id;


    public FamilyMember(String firstName, String lastName, int age, String status,int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
        this.salary = salary;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}
