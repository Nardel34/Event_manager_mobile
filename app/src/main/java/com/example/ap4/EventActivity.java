package com.example.ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
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

import java.util.ArrayList;

import Adapter.EventAdapter;
import Adapter.TypeAdapter;
import Entity.Evenement;
import Entity.Type;

public class EventActivity extends AppCompatActivity {

    private final String urlListeEventById = "http://10.0.2.2:8000";
    private ArrayList<String> routesIdEvent;
    private String Lieu = "http://10.0.2.2:8000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(this.getIntent().getStringExtra("idType") != null)
        {
            TextView TXTevent = findViewById(R.id.TXTevent);
            TXTevent.setText(this.getIntent().getStringExtra("nomType"));

            routesIdEvent = this.getIntent().getStringArrayListExtra("evenements");
        }

        ListView listEvent = findViewById(R.id.listEvent);
        EventAdapter eventAdapter = new EventAdapter(this, R.layout.ligne_guest);

        for (int i = 0; i < routesIdEvent.size(); i++) {
            final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    urlListeEventById + routesIdEvent.get(i),
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                //JSONArray listEventJson = response.getJSONArray("hydra:member");
                                //JSONObject eventJson = listEventJson.getJSONObject(i);                                    JSONObject eventJson = listEventJson.getJSONObject(i);
                                JSONObject eventJson = response;

                                Evenement event = new Evenement();
                                event.setDateEvent(eventJson.getString("dateEvent"));
                                event.setPersonnes(eventJson.getString("personnes"));

                                eventAdapter.add(event);
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
        }
        listEvent.setAdapter(eventAdapter);
    }
}