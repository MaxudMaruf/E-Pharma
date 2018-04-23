package com.arka.dubusportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class testactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_layout);
        EditText passwordField = findViewById(R.id.password);
        String pass = passwordField.getText().toString();

        if(pass.length()<7)
        {
            Toast.makeText(this,"password too short", Toast.LENGTH_LONG);
        }

    }
}
