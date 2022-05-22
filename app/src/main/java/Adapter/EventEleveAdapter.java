package Adapter;

import android.content.Context;
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
import com.example.ap4.R;

import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.transform.Result;

import Entity.Evenement;

public class EventEleveAdapter extends ArrayAdapter {

    public EventEleveAdapter(Context context, int textViewRessourceId){
        super(context, textViewRessourceId);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View result = convertView;

        if (convertView == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.ligne_eleve, parent, false);
        }

        Evenement event = (Evenement) getItem(position);

        TextView txtdate = (TextView) result.findViewById(R.id.date);
        txtdate.setText(event.getDateEvent());

        TextView txtlieu = (TextView) result.findViewById(R.id.adresse);
        txtlieu.setText(event.getLieu());

        TextView txttype = (TextView) result.findViewById(R.id.nomType);
        txttype.setText(event.getType());

        return result;
    }
}
