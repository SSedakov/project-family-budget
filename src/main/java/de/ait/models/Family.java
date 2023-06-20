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

     class IncomeExpenses {
    private String title;
    private int sum;
    private String id;

        @Override
        public String toString() {
            return "IncomeExpenses{" +
                    "title='" + title + '\'' +
                    ", sum=" + sum +
                    ", id='" + id + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public IncomeExpenses(String title, int sum, String id) {
            this.title = title;
            this.sum = 0;
            this.id = UUID.randomUUID().toString();

        }



   // public void addBudget(int cash){
   //     balance = balance + ((cash/100) * 90);
   //     asideMoney = asideMoney + ((cash/100) * 10);
   //}

    }

