package de.ait.models;

import java.time.LocalDate;
import java.util.UUID;

public class Expense {
    private String purpose;
    private int sum;
    private LocalDate date;
    private String id;

    public Expense(String purpose, int sum, LocalDate date) {
        this.purpose = purpose;
        this.sum = sum;
        this.date = date;
        this.id = UUID.randomUUID().toString();
    }

    public String getPurpose() {
        return purpose;
    }

    public double getSum() {
        return sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "Списание ='" + purpose + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                ", id='" + id + '\'' +
                '}';
    }
}
