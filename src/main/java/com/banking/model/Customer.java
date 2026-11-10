package com.banking.model;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String firstName;
    private String surname;
    private String address;
    private String contactInfo;
    private List<Account> accounts;

    public Customer(String customerId, String firstName, String surname, String address, String contactInfo) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.contactInfo = contactInfo;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getFullName() { return firstName + " " + surname; }
    public List<Account> getAccounts() { return accounts; }

    public String getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public String getContactInfo() { return contactInfo; }
}