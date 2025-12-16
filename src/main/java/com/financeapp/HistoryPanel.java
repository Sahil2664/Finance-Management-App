package com.financeapp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoryPanel extends JPanel {

    private JTextArea area;
    private JLabel balance;

    public HistoryPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(UIStyle.card());
        setBackground(UIStyle.BG);

        JLabel title = new JLabel("Transaction History");
        title.setFont(UIStyle.TITLE);
        title.setForeground(UIStyle.PRIMARY);

        area = new JTextArea();
        area.setEditable(false);

        balance = new JLabel("Balance: Rs. 0");
        balance.setFont(UIStyle.TITLE);
        balance.setForeground(UIStyle.SUCCESS);

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(balance, BorderLayout.SOUTH);
    }

    public void refresh(List<Transaction> list, double bal) {
        area.setText("");
        for (Transaction t : list) {
            area.append(t + "\n");
        }
        balance.setText("Balance: Rs. " + bal);
    }
}
