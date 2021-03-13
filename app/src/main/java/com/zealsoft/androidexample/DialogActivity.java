package com.zealsoft.androidexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity
{

    String[] courses={"BCA","MCA","Bsc","MSc"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        Button btnSelect=findViewById(R.id.btnSelect);
        TextView txtCourse=findViewById(R.id.txtCourse);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("Select Course")
                        .setSingleChoiceItems(courses, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int position) {
                                txtCourse.setText(courses[position]);
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_profile)
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setMultiChoiceItems(courses, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                //.setMessage("Hi....");

                builder.create().show();

            }
        });
    }
}
