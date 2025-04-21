package com.example.shariq;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shariq.Students_Providers;

public class prog10 extends AppCompatActivity {
    Uri CONTENT_URI = Students_Providers.CONTENT_URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertStudent("Ali", "101");
        insertStudent("Zara", "102");

        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String roll = cursor.getString(cursor.getColumnIndexOrThrow("roll"));
                Toast.makeText(this, "Name: " + name + ", Roll: " + roll, Toast.LENGTH_SHORT).show();
            } while (cursor.moveToNext());
            cursor.close();
        }
    }

    private void insertStudent(String name, String roll) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("roll", roll);
        getContentResolver().insert(CONTENT_URI, values);
    }
}
