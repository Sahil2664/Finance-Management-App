package com.financeapp;

import java.awt.*;
import javax.swing.*;

public class ThemeManager {

    public static boolean darkMode = false;

    public static Color DARK_BG = new Color(18, 18, 18);
    public static Color DARK_PANEL = new Color(32, 32, 32);
    public static Color DARK_TEXT = new Color(220, 220, 220);

    public static Color LIGHT_BG = new Color(245, 246, 250);
    public static Color LIGHT_PANEL = Color.WHITE;
    public static Color LIGHT_TEXT = new Color(33, 37, 41);

    public static void applyTheme(Component c) {
        if (darkMode) {
            c.setBackground(DARK_PANEL);
            c.setForeground(DARK_TEXT);
        } else {
            c.setBackground(LIGHT_PANEL);
            c.setForeground(LIGHT_TEXT);
        }

        if (c instanceof Container) {
            for (Component child : ((Container) c).getComponents()) {
                applyTheme(child);
            }
        }
    }
}
