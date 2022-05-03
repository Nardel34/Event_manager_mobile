package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InscProfActivity extends AppCompatActivity {

    protected final String inscURL = "http://10.0.2.2:8000/api/create";

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

                if(password.getText().toString().equals(confirmPassword.getText().toString())) {

                    JSONObject json = new JSONObject();
                    try {
                        json.put("email", email.getText().toString().trim());
                        json.put("password", password.getText().toString().trim());
                        json.put("nom", nom.getText().toString().trim());
                        json.put("prenom", prenom.getText().toString().trim());
                        json.put("age", age.getText().toString().trim());
                        json.put("expPro", exp.getText().toString().trim());
                        json.put("diplome", diplome.getText().toString().trim());
                        json.put("roles", new JSONArray(new String[]{"ROLE_PROF"}));

                        //params.put("DateEntree", new Date().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // Make request for JSONObject
                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                            Request.Method.POST, inscURL, json,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(getApplicationContext(), "Inscription réussite", Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(InscProfActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Une erreur est survenue", Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();
                            headers.put("Content-Type", "application/json; charset=utf-8");
                            return headers;
                        }
                    };
                    Volley.newRequestQueue(getApplicationContext()).add(jsonObjReq);
                } else {
                    Toast.makeText(getApplicationContext(), "Les mot de passe ne corresponde pas", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}