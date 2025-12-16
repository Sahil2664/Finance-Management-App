package com.financeapp;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Personal Finance Dashboard");
        setSize(900, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        TransactionManager manager = new TransactionManager();
        HistoryPanel history = new HistoryPanel();
        DashboardPanel dashboard = new DashboardPanel(manager, history);

        JLabel header = new JLabel("💰 Welcome to Finance Manager");
        header.setFont(UIStyle.TITLE);
        header.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        add(header, BorderLayout.NORTH);
        add(dashboard, BorderLayout.WEST);
        add(history, BorderLayout.CENTER);

        setVisible(true);
    }
}
