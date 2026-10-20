package com.banking.model;

public class EmployeeDetails {
    private String companyName;
    private String companyAddress;

    public EmployeeDetails(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() { return companyName; }
    public String getCompanyAddress() { return companyAddress; }
}