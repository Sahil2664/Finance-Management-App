package com.financeapp;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DashboardPanel extends JPanel {

    private TransactionManager manager;
    private HistoryPanel history;

    private JTextField amountField;
    private JTextField categoryField;
    private JComboBox<String> typeBox;

    public DashboardPanel(TransactionManager manager, HistoryPanel history) {
        this.manager = manager;
        this.history = history;

        setLayout(new BorderLayout());
        setBackground(UIStyle.BG);

        JPanel card = new JPanel(new GridLayout(9, 1, 10, 10));
        card.setBorder(UIStyle.card());
        card.setBackground(Color.WHITE);

        JLabel title = new JLabel("Add Transaction");
        title.setFont(UIStyle.TITLE);
        title.setForeground(UIStyle.PRIMARY);

        amountField = new JTextField();
        categoryField = new JTextField();
        typeBox = new JComboBox<>(new String[]{"Income", "Expense"});

        card.add(title);
        card.add(new JLabel("Amount"));
        card.add(amountField);
        card.add(new JLabel("Category"));
        card.add(categoryField);
        card.add(new JLabel("Type"));
        card.add(typeBox);

        JButton addBtn = UIStyle.button("Add Transaction", UIStyle.SUCCESS);
        card.add(addBtn);

        add(card, BorderLayout.NORTH);

        addBtn.addActionListener(e -> addTransaction());
    }

    private void addTransaction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();

            if (category.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter category");
                return;
            }

            Transaction t = new Transaction(
                    typeBox.getSelectedItem().toString(),
                    amount,
                    category,
                    new Date()
            );

            manager.addTransaction(t);

            history.refresh(manager.getTransactions(), manager.getBalance());

            amountField.setText("");
            categoryField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount");
        }
    }
}
