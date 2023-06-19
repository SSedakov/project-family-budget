package de.ait.models;

import java.util.List;

public class Family {
    List<FamilyMember> family;
    private double balance;

    public Family(List<FamilyMember> family) {
        this.family = family;
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "Family{" +
                "family=" + family +
                ", balance=" + balance +
                '}';
    }
}
