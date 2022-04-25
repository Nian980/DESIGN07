package com.project.favourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button nextbtn;
    TextView subjectIdTextView;
    Spinner subjectSpinner;
    String[] Subjects = {"Math", "English", "Chemistry", "Biology"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); // For Views

    }

    public void init() {

        // Views
        nextbtn = findViewById(R.id.nextbtn);
        subjectIdTextView = findViewById(R.id.subjectIdTextView);
        subjectSpinner = findViewById(R.id.subjectSpinner);
        arrayAdapter();

        onClickEvent(); // for OnClick Event
    }

    private void onClickEvent() {
        nextbtn.setOnClickListener(this); // Next Button OnClick
        subjectIdTextView.setOnClickListener(this); // on Drop down of Subject Click
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.nextbtn) {
            nextPage(); // code for Next Page
        } else if (view.getId() == R.id.subjectSpinner) {
            openSubectDropDown(); // Method For Drop Down Code
        }
    }

    private void openSubectDropDown() {

        //On Click of DropDown data set
        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                subjectIdTextView.setText(Subjects[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void arrayAdapter() {

        //Array Adapter for dropdown and Set Data in that Adapter
        ArrayAdapter subjectAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Subjects);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);
        openSubectDropDown();
    }

    private void nextPage() {
        // Next Page Choose Tuor Going Click Event Code
        Intent intent = new Intent(MainActivity.this, ChooseTutorActivity.class);
        startActivity(intent);
    }
}