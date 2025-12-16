package com.financeapp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable {

    private String type;
    private double amount;
    private String category;
    private Date date;

    public Transaction(String type, double amount, String category, Date date) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd-MM-yyyy")
                .format(date) + " | " + type + " | " + category + " | Rs. " + amount;
    }
}
