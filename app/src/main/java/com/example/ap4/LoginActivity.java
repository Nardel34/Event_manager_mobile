package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText input_Email;
    EditText input_Passwd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView SignUpProf = (TextView) findViewById(R.id.SignUpProf);
        TextView SignUpEleve = (TextView) findViewById(R.id.SignUpEleve);

        SignUpProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InscProfActivity.class);
                startActivity(intent);
            }
        });

        SignUpEleve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InscEleveActivity.class);
                startActivity(intent);
            }
        });

        input_Email = (EditText) findViewById(R.id.LOGINadresseEmail);
        input_Passwd = (EditText) findViewById(R.id.LOGINpasswd);
        login = (Button) findViewById(R.id.BTNconnexion);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}