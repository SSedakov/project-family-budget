package de.ait.models;

import java.util.List;
import java.util.UUID;

public class Family {
    List<FamilyMember> family;
    private int balance;
    private int asideMoney;
    private String id;

    public Family(List<FamilyMember> family) {
        this.family = family;
        this.balance = 0;
        this.asideMoney = 0;
        this.id = UUID.randomUUID().toString();
    }

    public Family() {
    }

    public void addBudget(int cash){
        balance = balance + ((cash/100) * 90);
        asideMoney = asideMoney + ((cash/100) * 10);
    }

    public int getAsideMoney() {
        return asideMoney;
    }

    public void setAsideMoney(int asideMoney) {
        this.asideMoney = asideMoney;
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
