package com.zealsoft.androidexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ItemViewHolder>
{
    List<Employee> empList;
    Context ctx;

    public EmployeeAdapter(List<Employee> empList, Context ctx) {
        this.empList = empList;
        this.ctx = ctx;
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
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView txtName,txtSalary;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtName=itemView.findViewById(R.id.txtEmpName);
            this.txtSalary=itemView.findViewById(R.id.txtEmpSalary);
        }
    }
}
