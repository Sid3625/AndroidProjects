package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewSubject = findViewById(R.id.textViewSubject);
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewQualifications = findViewById(R.id.textViewQualifications);

        String name = getIntent().getStringExtra("name");
        String subject = getIntent().getStringExtra("subject");
        String gender = getIntent().getStringExtra("gender");
        String qualifications = getIntent().getStringExtra("qualifications");

        textViewName.setText("Name: " + name);
        textViewSubject.setText("Subject: " + subject);
        textViewGender.setText("Gender: " + gender);
        textViewQualifications.setText("Qualifications: " + qualifications);
    }
}
