package com.banking.model;

public class ChequeAccount extends Account {
    private EmployeeDetails employeeDetails;

    public ChequeAccount(String accountNumber, String branch, double initialBalance, EmployeeDetails employeeDetails) {
        super(accountNumber, branch, initialBalance);
        if (employeeDetails == null) {
            throw new IllegalArgumentException("Cheque Account requires employment details.");
        }
        this.employeeDetails = employeeDetails;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(amount, "WITHDRAWAL"));
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }
}