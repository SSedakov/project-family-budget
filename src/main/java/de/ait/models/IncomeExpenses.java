package de.ait.models;

import java.util.UUID;

public class IncomeExpenses {
    private String title;
    private int sum;
    private String id;
    private int familyId;

    public IncomeExpenses(String title, int sum,int familyId) {
        this.title = title;
        this.sum = sum;
        this.id = UUID.randomUUID().toString();
        this.familyId = familyId;

    }



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





}
