package com.financeapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<Transaction> transactions = new ArrayList<>();
    private double balance = 0.0;

    public void addTransaction(Transaction t) {
        transactions.add(t);

        if (t.getType().equalsIgnoreCase("Income")) {
            balance += t.getAmount();
        } else {
            balance -= t.getAmount();
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void saveData() throws IOException {
        ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("transactions.dat"));
        out.writeObject(transactions);
        out.writeDouble(balance);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("transactions.dat"));
        transactions = (List<Transaction>) in.readObject();
        balance = in.readDouble();
        in.close();
    }
}
