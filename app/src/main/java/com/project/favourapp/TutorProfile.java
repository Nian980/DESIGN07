package com.project.favourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);

        TextView backPage = findViewById(R.id.backPage);
        ImageView imageBack = findViewById(R.id.imageBack);

        backPage.setOnClickListener(view -> onBackPressed()); // backPage image Click
        imageBack.setOnClickListener(view -> onBackPressed()); // on Click Event of ImageBack to go previous Page
    }

    public void bookSession(View view) {
        Intent i = new Intent(this, SessionSummaryActivity.class);
        // To Pass the data from This Page to Session Summary page
        i.putExtra("name", "John Smith");
        i.putExtra("time", "$20/15 mins");
        i.putExtra("image", R.drawable.tutor_one);
        i.putExtra("rating", 3.5F);

        Intent intent = getIntent();
        String iDesc = intent.getStringExtra("desc");
        i.putExtra("desc", iDesc);
        startActivity(i);
    }
}