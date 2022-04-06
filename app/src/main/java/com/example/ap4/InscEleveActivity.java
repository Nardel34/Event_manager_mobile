package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class InscEleveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insc_eleve);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner tarifSpinner = findViewById(R.id.tarifSpinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.tarifSpinnerValues,
                R.layout.color_spinner_layout
        );
        tarifSpinner.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        tarifSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}