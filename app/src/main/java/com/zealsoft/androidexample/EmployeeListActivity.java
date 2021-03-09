package com.zealsoft.androidexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emp_list_layout);

        RecyclerView rvEmpList=findViewById(R.id.rvEmpList);

        Employee e=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e1=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e2=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e3=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e4=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e5=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e6=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e7=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e8=new Employee("Ashish",45000,"Soft Developer","Bsl");
        Employee e9=new Employee("Ashish",45000,"Soft Developer","Bsl");

        List<Employee> empList=new ArrayList<>();

        empList.add(e);
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        empList.add(e6);
        empList.add(e7);
        empList.add(e8);
        empList.add(e9);

        rvEmpList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvEmpList.setAdapter(new EmployeeAdapter(empList,this));


    }
}
