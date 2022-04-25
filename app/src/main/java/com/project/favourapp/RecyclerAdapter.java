package com.project.favourapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.favourapp.databinding.DesignTutorsBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<Tutors> tutorsList = new ArrayList<>();

    public RecyclerAdapter(Context context, List<Tutors> tutorsList) {
        this.context = context;
        this.tutorsList = tutorsList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        DesignTutorsBinding designTutorsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.design_tutors,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(designTutorsBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Tutors tutors = tutorsList.get(position);
        holder.itemLayoutBinding.viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SessionSummaryActivity.class);
                // To Pass the data from This Page to Session Summary page
                i.putExtra("name",holder.itemLayoutBinding.tutorName.getText());
                i.putExtra("time",holder.itemLayoutBinding.timeTutor.getText());
                i.putExtra("image",holder.itemLayoutBinding.getTutors().imageId);
                i.putExtra("rating",tutorsList.get(position).ratingId);
                ((Activity)context).overridePendingTransition(R.anim.slide_from_left,R.anim.slide_from_right); // Animation
                context.startActivity(i);

            }
        });
        holder.itemLayoutBinding.setTutors(tutors); // Set Tutors
        holder.itemLayoutBinding.rating.setRating(tutorsList.get(position).ratingId); // Set Rating
    }


    @Override
    public int getItemCount() {
        return tutorsList.size();

    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder {
        DesignTutorsBinding itemLayoutBinding;  // Data binding for all Items of Tutors
        public MyViewHolder(@NonNull DesignTutorsBinding itemView) {
            super(itemView.getRoot());

            itemLayoutBinding = itemView;

        }
    }
}