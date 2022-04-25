package com.project.favourapp;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class Tutors {

    public String name, time;
    public int imageId;
    public float ratingId;

    //Constructor of Name , Time , Image ID and RatingId
    public Tutors(String name, String time, int imageId, float ratingId) {
        this.name = name;
        this.time = time;
        this.imageId = imageId;
        this.ratingId = ratingId;
    }


    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int imageId) {
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), imageId));
    }
}
