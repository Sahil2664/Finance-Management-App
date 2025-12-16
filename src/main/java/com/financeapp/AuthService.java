package com.financeapp;

import java.security.MessageDigest;

public class AuthService {

    private static final String USERNAME = "admin";
    private static final String PASSWORD_HASH = hash("admin123");

    public static boolean login(String user, String pass) {
        return USERNAME.equals(user) && PASSWORD_HASH.equals(hash(pass));
    }

    private static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
