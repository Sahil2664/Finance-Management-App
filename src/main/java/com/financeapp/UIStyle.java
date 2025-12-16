package com.financeapp;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UIStyle {

    public static final Font TITLE = new Font("Segoe UI", Font.BOLD, 20);
    public static final Font NORMAL = new Font("Segoe UI", Font.PLAIN, 14);

    // 🎨 Color Palette
    public static final Color PRIMARY = new Color(72, 61, 139);   // Indigo
    public static final Color SUCCESS = new Color(46, 204, 113);  // Green
    public static final Color WARNING = new Color(241, 196, 15);  // Yellow
    public static final Color DANGER  = new Color(231, 76, 60);   // Red
    public static final Color BG      = new Color(245, 247, 250); // Light background

    // 📦 Card style
    public static Border card() {
        return BorderFactory.createCompoundBorder(
                new LineBorder(new Color(180, 180, 180), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        );
    }

    // 🎯 Button style
    public static JButton button(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(NORMAL);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
}
