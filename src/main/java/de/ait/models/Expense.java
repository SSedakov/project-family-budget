package de.ait.models;

import java.time.LocalDate;

public class Expense {
    private String purpose;
    private double sum;
    private LocalDate date;

    public Expense(String purpose, double sum, LocalDate date) {
        this.purpose = purpose;
        this.sum = sum;
        this.date = date;
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

    @Override
    public String toString() {
        return "Expense{" +
                "purpose='" + purpose + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                '}';
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
