package edu.nure.ua.dto;

public abstract class BankCard {
    protected String number;
    protected User user;

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }

    // Гетери
    public String getNumber() { return number; }
    public User getUser() { return user; }
}