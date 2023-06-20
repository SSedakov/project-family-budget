package de.ait.models;

import java.util.List;
import java.util.UUID;

public class Family {
    List<FamilyMember> family;
    private int balance;
    private String id;

    public Family(List<FamilyMember> family) {
        this.family = family;
        this.balance = 0;
        this.id = UUID.randomUUID().toString();
    }


    public void addBalance(int sum){
        this.balance += sum;
    }

    public List<FamilyMember> getFamily() {
        return family;
    }

    public void setFamily(List<FamilyMember> family) {
        this.family = family;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Family{" +
                "family=" + family +
                ", balance=" + balance +
                ", id='" + id + '\'' +
                '}';
    }
}
