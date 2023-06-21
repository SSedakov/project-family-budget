package de.ait.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Family {
    List<FamilyMember> family;
    private int balance;
    private int asideMoney;
    private String id;
    List<IncomeExpenses> incomeExpenses;

    public Family(List<FamilyMember> family, int balance, int asideMoney, String id,  List<IncomeExpenses> incomeExpenses) {
        this.family = family;
        this.balance = balance;
        this.asideMoney = asideMoney;
        this.id = id;
        this.incomeExpenses = new ArrayList<IncomeExpenses>();

    }



    @Override
    public String toString() {
        return "Family{" +
                "family=" + family +
                ", balance=" + balance +
                ", asideMoney=" + asideMoney +
                ", id='" + id + '\'' +
                ", incomeExpenses=" + incomeExpenses +
                '}';
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

    public int getAsideMoney() {
        return asideMoney;
    }

    public void setAsideMoney(int asideMoney) {
        this.asideMoney = asideMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<IncomeExpenses> getIncomeExpenses() {
        return incomeExpenses;
    }

    public void setIncomeExpenses(List<IncomeExpenses> incomeExpenses) {
        this.incomeExpenses = incomeExpenses;
    }


}

