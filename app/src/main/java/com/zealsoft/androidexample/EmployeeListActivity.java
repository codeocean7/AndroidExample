package com.zealsoft.androidexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity
{

    FirebaseFirestore firestoreDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emp_list_layout);

        RecyclerView rvEmpList=findViewById(R.id.rvEmpList);

        firestoreDB=FirebaseFirestore.getInstance();

        List<String> desValues=new ArrayList<>();
        desValues.add("Soft Dev");
        desValues.add("Test Eng");

        firestoreDB.collection("EMPLOYEES")
                //.whereIn("empDesignation",desValues)
                //.whereGreaterThan("empSalary",35000)
                //.whereEqualTo("empName","Ashish")
                //.whereGreaterThan("empSalary",35000)
                //.whereEqualTo("empDesignation","Soft Dev")
                //.limit(3)
                .orderBy("empSalary", Query.Direction.DESCENDING)
                //.endAt(30000)
                //.startAt(30000)
                //.endBefore(25000)
                //.startAfter(55000)

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            List<Employee> empList=new ArrayList<>();

                            for (DocumentSnapshot doc:task.getResult()){
                                Employee emp=doc.toObject(Employee.class);
                                emp.setEmpId(doc.getId());
                                empList.add(emp);
                            }
                            rvEmpList.setLayoutManager(new LinearLayoutManager(EmployeeListActivity.this,LinearLayoutManager.VERTICAL,false));
                            rvEmpList.setAdapter(new EmployeeAdapter(empList,EmployeeListActivity.this));

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EmployeeListActivity.this,"Fail...",Toast.LENGTH_LONG).show();
            }
        });

    }
}
