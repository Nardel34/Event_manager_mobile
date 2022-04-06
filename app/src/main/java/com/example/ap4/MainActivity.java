package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Adapter.TypeAdapter;
import Entity.Type;

public class MainActivity extends AppCompatActivity {

    private final String urlListeType = "http://10.0.2.2:8000/api/types?page=1";

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menugeneral, menu);

        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listType = findViewById(R.id.listType);
        TypeAdapter typeAdapter = new TypeAdapter(this, R.layout.ligne_btn_event);

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlListeType,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray listTypeJson = response.getJSONArray("hydra:member");
                            for (int i = 0; i < listTypeJson.length(); i++){
                                JSONObject typeJson = listTypeJson.getJSONObject(i);

                                Type type = new Type();
                                type.setId(typeJson.getString("id"));
                                type.setNomType(typeJson.getString("nomType"));
                                type.setDescription(typeJson.getString("description"));

                                Log.i("Type", typeJson.getString("nomType"));
                                typeAdapter.add(type);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Log.i("ErrorResponseConnection", e.getMessage());
                        Toast.makeText(getApplicationContext(), "Une erreur est survenue", Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
        listType.setAdapter(typeAdapter);
    }



    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch(item.getItemId())
        {
            case R.id.MenuConnexion:
                Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLogin);
                return true;

            case R.id.MenuSignupProf:
                Intent intentProf = new Intent(MainActivity.this, InscProfActivity.class);
                startActivity(intentProf);
                return true;

            case R.id.MenuSignupEleve:
                Intent intentEleve = new Intent(MainActivity.this, InscEleveActivity.class);
                startActivity(intentEleve);
                return true;
        }

        return true;
    }
}