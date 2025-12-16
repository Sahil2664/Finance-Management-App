package com.financeapp;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryPanel {
    public static void showSummary(List<Transaction> transactions) {
        Map<String, Double> summary = new HashMap<>();
        for (Transaction t : transactions)
            if (t.getType().equals("Expense"))
                summary.put(t.getCategory(), summary.getOrDefault(t.getCategory(), 0.0) + t.getAmount());

        StringBuilder sb = new StringBuilder("Monthly Expense Summary:\n");
        for (Map.Entry<String, Double> entry : summary.entrySet())
            sb.append(entry.getKey()).append(": Rs. ").append(entry.getValue()).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString(), "Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
