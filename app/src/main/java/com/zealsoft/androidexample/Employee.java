package com.zealsoft.androidexample;

public class Employee {

    String empName;
    int empSalary;
    String empDesignation;
    String empAddress;

    public Employee(String empName, int empSalary, String empDesignation, String empAddress) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDesignation = empDesignation;
        this.empAddress = empAddress;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public String getEmpAddress() {
        return empAddress;
    }
}
