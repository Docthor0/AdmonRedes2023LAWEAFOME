package mx.edu.itsuruapan.admnistracionderedes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.Objects;

public class JFallas extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    Button BAtras;
    Button BBuscar;
    Button BNuevo;
    Button BLista;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    ArrayList<ListElementListar> elements = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_fallas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        BAtras =(Button)findViewById(R.id.botonReturnF);
        BBuscar=(Button)findViewById(R.id.botonBuscarF);
        BNuevo=(Button)findViewById(R.id.botonAñadirFallasF);
        BLista=(Button)findViewById(R.id.botonListaFallasF);


        BNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JFallas.this, JaddFallas.class);
                startActivity(intent);
            }
        });


        BBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JFallas.this, JresultadosFallas.class);
                startActivity(intent);
            }
        });

        BAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JFallas.this,menu.class);
                startActivity(intent);
            }
        });

        buscarLista();


    }


    public void buscarLista(){

        String url = "https://la-wea-redes.000webhostapp.com/hshaPHPs/buscarListarFallas.php";

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray json = response.optJSONArray("fallas");
        JSONObject object;

        for(int i = 0; i<json.length();i++){
            try{
                object = Objects.requireNonNull(json).getJSONObject(i);
                elements.add(new ListElementListar(object.optString("id_Fallas"),object.optString("nombre"),object.optString("descripcion"),object.optString("riesgo")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ListAdapterListar ListAdapterListar = new ListAdapterListar(elements,this);
        RecyclerView recyclerView = findViewById(R.id.recVIFallas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ListAdapterListar);

    }


}