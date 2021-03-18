package com.zealsoft.androidexample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Employee implements Serializable {

    String empName;
    int empSalary;
    String empDesignation;
    String empAddress;
    String empId;

    public Employee(String empName, int empSalary, String empDesignation, String empAddress) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDesignation = empDesignation;
        this.empAddress = empAddress;
    }

    public Employee() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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
        mMap.put("empName",this.empName);
        mMap.put("empSalary",this.empSalary);
        mMap.put("empDesignation",this.empDesignation);
        mMap.put("empAddress",this.empAddress);

        return  mMap;
    }
}
