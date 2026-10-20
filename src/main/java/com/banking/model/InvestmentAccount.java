package com.banking.model;

public class InvestmentAccount extends Account {
    private final double interestRate = 0.05; // 5%
    public static final double MIN_OPENING_BALANCE = 500.00;

    public InvestmentAccount(String accountNumber, String branch, double initialBalance) {
        super(accountNumber, branch, initialBalance);
        if (initialBalance < MIN_OPENING_BALANCE) {
            throw new IllegalArgumentException("Investment Account requires a minimum opening balance of BWP " + MIN_OPENING_BALANCE);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(amount, "WITHDRAWAL"));
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}