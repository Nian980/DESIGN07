package com.project.favourapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.favourapp.databinding.ActivitySessionSummaryBinding;

public class SessionSummaryActivity extends AppCompatActivity {

    String newString;
    String time;
    int image;
    float rating;
    private ActivitySessionSummaryBinding databinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Data binding used for Binding the Views
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_session_summary);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("name");  // to get Data from RecyclerAdapter of TutorName to this Page
        time = extras.getString("time"); // To get Data from RecyclerAdapter of Tutor Time to this Page
        image = getIntent().getIntExtra("image", R.drawable.tutor_one); // To get Image Id wise
        rating = getIntent().getFloatExtra("rating", 4); // To get rating

        // To set Data
        databinding.tutorName.setText(newString);
        databinding.timeTutor.setText(time);
        databinding.profileImage.setImageResource(image);
        databinding.rating.setRating(rating);
        databinding.backPage.setOnClickListener(view -> onBackPressed()); // backPage image Click
        databinding.imageBack.setOnClickListener(view -> onBackPressed()); // on Click Event of ImageBack to go previous Page

        databinding.nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SessionSummaryActivity.this, VideoSession.class);  // On Button Click , goes from this Page to VideoSession Page
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_from_right); // Animation
                startActivity(i);
            }
        });
    }
}