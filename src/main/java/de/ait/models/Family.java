package de.ait.models;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Family {
    private int balance;
    private int asideMoney;
    private int familyId;

    public Family( int balance, int asideMoney, int familyId) {
        this.balance = balance;
        this.asideMoney = asideMoney;
        this.familyId = familyId;
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

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Override
    public String toString() {
        return "Family{" +
                "balance=" + balance +
                ", asideMoney=" + asideMoney +
                ", familyId='" + familyId + '\'' +
                '}';
    }
}
