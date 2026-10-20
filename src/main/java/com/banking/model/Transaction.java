package com.banking.model;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private LocalDateTime date;
    private double amount;
    private String type; // "DEPOSIT", "WITHDRAWAL", "INTEREST"

    public Transaction(double amount, String type) {
        this.transactionId = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }

    public String getDetails() {
        return date + " | " + type + " | Amount: BWP " + amount;
    }
}