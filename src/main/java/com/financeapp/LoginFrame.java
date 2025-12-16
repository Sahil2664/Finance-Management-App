package com.financeapp;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        setTitle("Finance Manager Login");
        setSize(420, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 🌈 Gradient background panel
        JPanel bg = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(72, 61, 139),
                        0, getHeight(), new Color(123, 104, 238)
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new GridBagLayout());

        JPanel card = new JPanel(new GridLayout(6, 1, 10, 10));
        card.setBorder(UIStyle.card());
        card.setBackground(Color.WHITE);

        JLabel title = new JLabel("Welcome Back", SwingConstants.CENTER);
        title.setFont(UIStyle.TITLE);
        title.setForeground(UIStyle.PRIMARY);

        userField = new JTextField();
        passField = new JPasswordField();

        JButton loginBtn = UIStyle.button("LOGIN", UIStyle.PRIMARY);

        card.add(title);
        card.add(new JLabel("Username"));
        card.add(userField);
        card.add(new JLabel("Password"));
        card.add(passField);
        card.add(loginBtn);

        bg.add(card);
        add(bg);

        loginBtn.addActionListener(e -> authenticate());

        setVisible(true);
    }

    private void authenticate() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (AuthService.login(user, pass)) {
            dispose();
            new DashboardFrame();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Credentials",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
