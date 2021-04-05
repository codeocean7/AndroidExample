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

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zealsoft.androidexample.R;


public class RegistrationActivity extends AppCompatActivity {

    EditText edtEmail,edtPass;
    Button btnReg;

    FirebaseAuth mAuth;
    ActionCodeSettings acs;

    SignInButton btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        mAuth=FirebaseAuth.getInstance();

        acs=ActionCodeSettings.newBuilder()
                .setHandleCodeInApp(true)
                .setUrl("https://www.example.com/finishSignUp?cartId=1234")
                .setAndroidPackageName(
                        "com.zealsoft.androidexample\n",
                        true, /* installIfNotAvailable */
                        "12"    /* minimumVersion */)
                .build();

        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPassword);

        btnReg=findViewById(R.id.btnRegister);
        btnSignIn=findViewById(R.id.btnGoogleSignin);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                registerUser(edtEmail.getText().toString(),edtPass.getText().toString());

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void registerUser(String email,String pass){
        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            mAuth.sendSignInLinkToEmail(email,acs)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(RegistrationActivity.this,"Varification Link Send",Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(RegistrationActivity.this,"Sending Fail",Toast.LENGTH_LONG).show();

                                }
                            });

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
