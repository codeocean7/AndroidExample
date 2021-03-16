package com.zealsoft.androidexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class  FormActivity extends AppCompatActivity {

    EditText edtEmpName,edtEmpSalary,edtEmpDesignation,edtEmpAddress;
    Button btnSubmit;

    //declaration
    FirebaseFirestore firestoreDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);

        edtEmpName=findViewById(R.id.edtEmpName);
        edtEmpSalary=findViewById(R.id.edtEmpSalary);
        edtEmpDesignation=findViewById(R.id.edtEmpDesignation);
        edtEmpAddress=findViewById(R.id.edtEmpAddress);

        btnSubmit=findViewById(R.id.btnSubmit);

        //initialisation
        firestoreDB=FirebaseFirestore.getInstance();
        
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName=edtEmpName.getText().toString();
                String strDes=edtEmpDesignation.getText().toString();
                String strAddress=edtEmpAddress.getText().toString();
                int iSalary=Integer.parseInt(edtEmpSalary.getText().toString());

                Employee emp=new Employee(strName,iSalary,strDes,strAddress);

                //insertion
                firestoreDB.collection("EMPLOYEES")
                        .add(emp.toMap())
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(FormActivity.this,"Data Added",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(FormActivity.this,"Fail..",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
