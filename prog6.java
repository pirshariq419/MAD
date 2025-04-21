package com.example.shariq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class prog6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_dial) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_web) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_sms) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:1234567890"));
            intent.putExtra("sms_body", "Hello from my app!");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
