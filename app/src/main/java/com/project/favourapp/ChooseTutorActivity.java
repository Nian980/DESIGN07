package com.project.favourapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.project.favourapp.databinding.ActivityChooseTutorBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseTutorActivity extends AppCompatActivity {


    private RecyclerAdapter adapter;
    private ActivityChooseTutorBinding databinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Data Binding Used for Binding Data
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_choose_tutor);

        // Back Image Click Event
        databinding.backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Back Text Click Event
        databinding.backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // For RecyclerView to set Data for All the Tutors
        databinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databinding.recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(this, prepareTutors());
        databinding.recyclerView.setAdapter(adapter);  // Set Data in Adapter

    }

    private List<Tutors> prepareTutors() {
        List<String> tutornames = Arrays.asList(getResources().getStringArray(R.array.names));  // String Array List for Tutor Names
        List<String> times = Arrays.asList(getResources().getStringArray(R.array.time)); // Sting Array List for Time

        // Integer ArrayList Image Id for Tutors
        int[] imageId = {R.drawable.tutor_one, R.drawable.tutor_two, R.drawable.tor_three, R.drawable.tutor_four, R.drawable.tutor_five, R.drawable.tutor_six};

        //Float ArrayList for Rating bar
        float[] ratingbar = {3.5F, 4, 4.5F, 3.5F, 5, 4};
        List<Tutors> TutorsNames = new ArrayList<>();
        int count = 0;

        for (String name : tutornames) {
            TutorsNames.add(new Tutors(name, times.get(count), imageId[count], ratingbar[count])); // Add all the Data in Variable tutornames
            count++;
        }
        return TutorsNames; // Return List of Turtor ArrayList

    }
}