package com.example.anhkhoa.diffutil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by anh khoa on 11/16/2017.
 */

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    List<Student> studentList;
    Context context;

    public AdapterRecyclerView(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row =LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtten1.setText(studentList.get(position).getTen());
        holder.txtlop2.setText(studentList.get(position).getLop());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void dispath(List<Student> newlist) {
        DiffUtil studentFDiffUtil=new DiffUtil(newlist,studentList);
        android.support.v7.util.DiffUtil.DiffResult diffResult = android.support.v7.util.DiffUtil.calculateDiff(studentFDiffUtil);
        studentList.clear();
        studentList.addAll(newlist);
        diffResult.dispatchUpdatesTo(this);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtten1, txtlop2;

        public ViewHolder(View itemView) {
            super(itemView);
            txtten1 = itemView.findViewById(R.id.txtten);
            txtlop2 = itemView.findViewById(R.id.txtlop);

        }
    }
}