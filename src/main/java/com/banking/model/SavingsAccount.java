package com.banking.model;

public class SavingsAccount extends Account {
    private final double interestRate = 0.0005; // 0.05%

    public SavingsAccount(String accountNumber, String branch, double initialBalance) {
        super(accountNumber, branch, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}