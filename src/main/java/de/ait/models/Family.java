package de.ait.models;

import java.util.ArrayList;
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

    private static class IncomeExpenses {
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
    }
    List<IncomeExpenses> incomeExpenses =new ArrayList<IncomeExpenses>(); // Создали пустой лист доходов-расходов
                                                                          // на основе созданного выше вложенного класса
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
