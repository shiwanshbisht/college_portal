package com.example.collegeapp.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.teacherViewAdapter> {


    private List<TeacherData> list;
    private Context context;


    public TeacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public teacherViewAdapter onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout,parent,false);

        return new teacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  teacherViewAdapter holder, int position) {

        TeacherData items=list.get(position);
        holder.name.setText(items.getName());
        holder.email.setText(items.getEmail());
        holder.post.setText(items.getPost());


        try {
            Picasso.get().load(items.getImage()).placeholder(R.drawable.ic_profile1).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class teacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name,email,post;
        private ImageView imageView;

        public teacherViewAdapter(@NonNull  View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.teacherName);
            email=itemView.findViewById(R.id.teacherEmail);
            post=itemView.findViewById(R.id.teacherPost);
            imageView=itemView.findViewById(R.id.teacherImage);

        }
    }

}
