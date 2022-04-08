package Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ap4.EventActivity;
import com.example.ap4.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import Entity.Evenement;
import Entity.Type;

public class EventAdapter extends ArrayAdapter {

    private String prof;
    private final String urlProfById = "http://10.0.2.2:8000";

    public EventAdapter(Context context, int textViewRessourceId){
        super(context, textViewRessourceId);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View result = convertView;

        if (convertView == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.ligne_guest, parent, false);
        }

        Evenement event = (Evenement) getItem(position);


        TextView txtdate = (TextView) result.findViewById(R.id.Date);
        txtdate.setText(event.getDateEvent());

        TextView txtprof = (TextView) result.findViewById(R.id.prof);



        prof = event.getPersonnes();
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlProfById + prof,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject personneJson = response;

                            txtprof.setText(personneJson.getString("nom"));

                            Log.i("Personne", personneJson.getString("id"));
                        } catch (JSONException e) {
                            Log.i("Error1111", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Log.i("ErrorResponseConnection", e.getMessage());
                        Toast.makeText(getContext(), "Une erreur est survenue -- EventAdapter", Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);



        return result;
    }
}
