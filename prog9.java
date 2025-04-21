package com.example.sharedprefslogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class prog9 extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin, btnShow;

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "LoginPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnShow = findViewById(R.id.btnShow);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();

            Toast.makeText(prog9.this, "Login saved!", Toast.LENGTH_SHORT).show();
        });

        btnShow.setOnClickListener(v -> {
            String username = sharedPreferences.getString("username", "No username saved");
            String password = sharedPreferences.getString("password", "No password saved");

            Toast.makeText(prog9.this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_LONG)
                    .show();
        });
    }
}
