package Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.ap4.EventActivity;
import com.example.ap4.R;

import org.json.JSONException;
import org.json.JSONObject;

import Entity.Type;

public class TypeAdapter extends ArrayAdapter {

    public TypeAdapter(Context context, int textViewRessourceId){
        super(context, textViewRessourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View result = convertView;

        if (convertView == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.ligne_btn_event, parent, false);
        }

        Type type = (Type) getItem(position);

        Button btnMain = (Button) result.findViewById(R.id.btnType);
        btnMain.setText(type.getNomtype());

        btnMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0)
            {
                // Class path = Class.forName("com.example.event_manager_mobil." + type.getNomtype());

                Intent intent = new Intent(getContext(), EventActivity.class);
                intent.putExtra("idType", type.getId());
                intent.putExtra("nomType", type.getNomtype());
                getContext().startActivity(intent);
            }
        });

        return result;
    }
}
