package com.zealsoft.androidexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UpdateEmpActivity extends AppCompatActivity {

    EditText edtEmpName,edtEmpSalary,edtEmpDesignation,edtEmpAddress;
    Button btnUpdate;

    FirebaseFirestore firebaseDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_emp);

        edtEmpName=findViewById(R.id.edtEmpName);
        edtEmpSalary=findViewById(R.id.edtEmpSalary);
        edtEmpDesignation=findViewById(R.id.edtEmpDesignation);
        edtEmpAddress=findViewById(R.id.edtEmpAddress);

        firebaseDB=FirebaseFirestore.getInstance();

        btnUpdate=findViewById(R.id.btnUpdate);

        Employee emp=(Employee) getIntent().getSerializableExtra("emp");

        edtEmpAddress.setText(emp.getEmpAddress());
        edtEmpName.setText(emp.getEmpName());
        edtEmpSalary.setText(String.valueOf(emp.getEmpSalary()));
        edtEmpDesignation.setText(emp.getEmpDesignation());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map=new HashMap<>();
                map.put("empSalary",Integer.parseInt(edtEmpSalary.getText().toString()));

                firebaseDB.collection("EMPLOYEES").document(emp.getEmpId())
                        .update(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(UpdateEmpActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateEmpActivity.this,"Data Update Fail",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
