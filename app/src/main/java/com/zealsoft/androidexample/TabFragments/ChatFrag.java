package com.zealsoft.androidexample.TabFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zealsoft.androidexample.Employee;
import com.zealsoft.androidexample.EmployeeAdapter;
import com.zealsoft.androidexample.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFrag extends Fragment {


    Context ctx;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_chat,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvEmpList=view.findViewById(R.id.rvEmpFragList);

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

        rvEmpList.setLayoutManager(new LinearLayoutManager(ctx,LinearLayoutManager.VERTICAL,false));
        rvEmpList.setAdapter(new EmployeeAdapter(empList,ctx));

    }
}
