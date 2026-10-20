package com.banking.model;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected List<Transaction> transactions;

    public Account(String accountNumber, String branch, double initialBalance) {
        this.accountNumber = accountNumber;
        this.branch = branch;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        if (initialBalance > 0) {
            transactions.add(new Transaction(initialBalance, "DEPOSIT"));
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(amount, "DEPOSIT"));
        }
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public List<Transaction> getTransactions() { return transactions; }

    public abstract double calculateInterest();
}