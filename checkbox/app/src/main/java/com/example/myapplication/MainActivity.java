package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    Spinner spinnerSubject;
    RadioGroup radioGroupGender;
    CheckBox checkBoxGraduate;
    CheckBox checkBoxPostgraduate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        spinnerSubject = findViewById(R.id.spinnerSubject);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxGraduate = findViewById(R.id.checkBoxGraduate);
        checkBoxPostgraduate = findViewById(R.id.checkBoxPostgraduate);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String subject = spinnerSubject.getSelectedItem().toString();
                String gender = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();

                String qualifications = "";
                if(checkBoxGraduate.isChecked()){
                    qualifications += "Graduate ";
                }
                if(checkBoxPostgraduate.isChecked()){
                    qualifications += "Postgraduate";
                }

                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("subject", subject);
                intent.putExtra("gender", gender);
                intent.putExtra("qualifications", qualifications);
                startActivity(intent);
            }
        });
    }
}
