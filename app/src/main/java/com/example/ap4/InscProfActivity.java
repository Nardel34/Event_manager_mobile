package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InscProfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insc_prof);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}