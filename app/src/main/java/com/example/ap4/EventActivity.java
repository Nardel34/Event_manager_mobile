package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(this.getIntent().getStringExtra("idType") != null)
        {
            TextView TXTevent = findViewById(R.id.TXTevent);
            TXTevent.setText(this.getIntent().getStringExtra("nomType"));
        }
    }
}