package de.ait.models;

import java.time.LocalDate;
import java.util.UUID;

public class Accumulation {
    private String purpose;
    private int  sum;
    private LocalDate date;
    private String id;

    public Accumulation(String purpose, int sum, LocalDate date) {
        this.purpose = purpose;
        this.sum = 100;
        this.date = date;
        this.id = UUID.randomUUID().toString();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Accumulation{" +
                "Накопление ='" + purpose + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                ", id='" + id + '\'' +
                '}';
    }
}
