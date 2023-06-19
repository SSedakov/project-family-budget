package de.ait.models;

public class FamilyMember {
    private String firstName;
    private String lastName;
    private int age;
    private String status;


    public FamilyMember(String firstName, String lastName, int age, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
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
                '}';
    }
}
