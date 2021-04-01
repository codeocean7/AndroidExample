package com.zealsoft.androidexample.AuthWork;

import android.content.Intent;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zealsoft.androidexample.R;


public class RegistrationActivity extends AppCompatActivity {

    EditText edtEmail,edtPass;
    Button btnReg;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        mAuth=FirebaseAuth.getInstance();

        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPassword);

        btnReg=findViewById(R.id.btnRegister);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser(edtEmail.getText().toString(),edtPass.getText().toString());

            }
        });
    }

    private void registerUser(String email,String pass){
        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this,"Registration Done",Toast.LENGTH_LONG).show();
                            Intent loginIntent=new  Intent(RegistrationActivity.this,LoginActivity.class);
                            startActivity(loginIntent);
                        }else{
                            Toast.makeText(RegistrationActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistrationActivity.this,"Registration Fail",Toast.LENGTH_LONG).show();
            }
        });
    }
}
