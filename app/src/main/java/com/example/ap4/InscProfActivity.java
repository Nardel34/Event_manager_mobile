package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InscProfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insc_prof);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText email = (EditText) findViewById(R.id.INSCprofEmail);
        EditText password = (EditText) findViewById(R.id.INSCprofPasswd);
        EditText confirmPassword = (EditText) findViewById(R.id.INSCprofConfirm);
        EditText nom = (EditText) findViewById(R.id.INSCprofNom);
        EditText prenom = (EditText) findViewById(R.id.INSCprofPrenom);
        EditText age = (EditText) findViewById(R.id.INSCprofAge);
        EditText exp = (EditText) findViewById(R.id.INSCprofExp);
        EditText diplome = (EditText) findViewById(R.id.INSCprofDiplome);
        Button btnProf = (Button) findViewById(R.id.btnInscriptionProf);

        btnProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}