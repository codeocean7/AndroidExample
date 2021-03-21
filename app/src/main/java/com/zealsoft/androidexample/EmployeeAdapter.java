package com.zealsoft.androidexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ItemViewHolder>
{
    List<Employee> empList;
    Context ctx;

    FirebaseFirestore firestoreDB;

    public EmployeeAdapter(List<Employee> empList, Context ctx) {
        this.empList = empList;
        this.ctx = ctx;
        this.firestoreDB=FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new ItemViewHolder(LayoutInflater.from(ctx).inflate(R.layout.emp_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Employee emp=empList.get(position);

        holder.txtName.setText(emp.getEmpName());
        holder.txtSalary.setText(String.valueOf(emp.getEmpSalary()));

        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx,UpdateEmpActivity.class);
                i.putExtra("emp",emp);
                ctx.startActivity(i);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firestoreDB.collection("EMPLOYEES")
                        .document(emp.getEmpId())
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(ctx, "Deleted...", Toast.LENGTH_SHORT).show();

                                empList.remove(position);
                                //refresh the adapter
                                notifyDataSetChanged();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ctx, "Delete FAil", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView txtName,txtSalary;
        Button btnDelete;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtName=itemView.findViewById(R.id.txtEmpName);
            this.txtSalary=itemView.findViewById(R.id.txtEmpSalary);
            this.btnDelete=itemView.findViewById(R.id.btnDelete);

        }
    }
}
