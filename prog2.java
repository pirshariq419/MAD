package com.example.nameapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class prog2 extends AppCompatActivity {
    EditText username, password, address, age;
    RadioGroup genderGroup;
    DatePicker dob;
    Spinner stateSpinner;
    Button submitBtn;
    TextView resultText;

    String[] states = { "Select State", "J&K", "Delhi", "Punjab" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        genderGroup = findViewById(R.id.genderGroup);
        dob = findViewById(R.id.dob);
        stateSpinner = findViewById(R.id.stateSpinner);
        submitBtn = findViewById(R.id.submitBtn);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, states);
        stateSpinner.setAdapter(adapter);

        submitBtn.setOnClickListener(v -> {
            String name = username.getText().toString();
            String pass = password.getText().toString();
            String addr = address.getText().toString();
            String userAge = age.getText().toString();
            String gender = ((RadioButton) findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString();
            String birthDate = dob.getDayOfMonth() + "/" + (dob.getMonth() + 1) + "/" + dob.getYear();
            String state = stateSpinner.getSelectedItem().toString();

            resultText.setText("Name: " + name + "\nPassword: " + pass + "\nAddress: " + addr +
                    "\nGender: " + gender + "\nAge: " + userAge + "\nDOB: " + birthDate + "\nState: " + state);
        });
    }
}
