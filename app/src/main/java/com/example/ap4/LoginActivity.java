package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import Entity.Personnes;

public class LoginActivity extends AppCompatActivity {

    protected final String loginURL = "http://10.0.2.2:8000/api/login";

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








        EditText input_Email = (EditText) findViewById(R.id.LOGINadresseEmail);
        EditText input_Passwd = (EditText) findViewById(R.id.LOGINpasswd);
        Button btnLogin = (Button) findViewById(R.id.BTNconnexion);
        Personnes user = new Personnes();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                loginURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject UserJson = new JSONObject(response);
                            Log.i("Login OK", response);

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("id", UserJson.getString("id"));
                            intent.putExtra("email", UserJson.getString("email"));
                            intent.putExtra("nom", UserJson.getString("nom"));
                            intent.putExtra("prenom", UserJson.getString("prenom"));
                            intent.putExtra("roles", UserJson.getString("roles"));
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Email ou mot de passe invalides", Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("email", input_Email.getText().toString().trim());
                        params.put("password", input_Passwd.getText().toString().trim());

                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
}