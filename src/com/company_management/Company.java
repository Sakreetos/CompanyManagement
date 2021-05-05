package com.company_management;

public class Company extends Address {
    public String companyName;
    public String getCompanyAddress;

    public Company(String companyName, String country, String city, String street, int building) {
        super(country, city, street, building);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

}