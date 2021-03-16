package com.zealsoft.androidexample;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String,Object> toMap(){
        Map<String,Object> mMap=new HashMap<>();
        mMap.put("EmpName",this.empName);
        mMap.put("EmpSalary",this.empSalary);
        mMap.put("EmpDesignation",this.empDesignation);
        mMap.put("EmpAddress",this.empAddress);

        return  mMap;
    }
}
