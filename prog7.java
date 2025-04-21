package com.example.shariq;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class prog7 extends AppCompatActivity {
    EditText etName;
    Button btnGreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnGreet = findViewById(R.id.btnGreet);

        btnGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                Toast.makeText(prog7.this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
