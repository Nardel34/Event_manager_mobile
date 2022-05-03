package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InscEleveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    protected final String inscURL = "http://10.0.2.2:8000/api/create";
    protected int value;

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

        EditText email = (EditText) findViewById(R.id.INSCeleveEmail);
        EditText password = (EditText) findViewById(R.id.INSCelevePasswd);
        EditText confirmPassword = (EditText) findViewById(R.id.INSCeleveConfirm);
        EditText nom = (EditText) findViewById(R.id.INSCeleveNom);
        EditText prenom = (EditText) findViewById(R.id.INSCelevePrenom);
        EditText age = (EditText) findViewById(R.id.INSCeleveAge);
        Button btnProf = (Button) findViewById(R.id.btnInscription);

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
                        json.put("roles", new JSONArray(new String[]{"ROLE_ELEVE"}));

                        int spinner_pos = tarifSpinner.getSelectedItemPosition();
                        String[] size_values = getResources().getStringArray(R.array.size_values);
                        value = Integer.valueOf(size_values[spinner_pos]); // 9, 10
                        json.put("tarifs", "api/tarifs/" + value);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                            Request.Method.POST, inscURL, json,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(getApplicationContext(), "Inscription réussite", Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(InscEleveActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();

                            //Toast.makeText(getApplicationContext(), "Une erreur est survenue", Toast.LENGTH_LONG).show();
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}