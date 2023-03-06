package mx.edu.itsuruapan.admnistracionderedes;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JresultadosInventario extends AppCompatActivity {

    Button BAtras;
    Button BEditar;
    Button BEliminar;
    ImageView IVBuscar;
    EditText ETID;
    EditText ETNombre;
    EditText ETCantidad;
    EditText ETDescripcion;

    RequestQueue requestQueue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_resultados_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BEditar=(Button)findViewById(R.id.botonModificarArt);
        BEliminar=(Button)findViewById(R.id.botonBorrarArt);
        BAtras=(Button)findViewById(R.id.botonReturnInvR);
        IVBuscar =(ImageView) findViewById(R.id.imageViewBuscarArtR);

        ETID =(EditText)findViewById(R.id.campoIDArtBusqueda);
        ETNombre=(EditText)findViewById(R.id.campoNombreArtBusqueda);
        ETCantidad=(EditText)findViewById(R.id.campoCantidadArtBusqueda);
        ETDescripcion=(EditText)findViewById(R.id.campoDescripcionArtBusqueda);

        BAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JresultadosInventario.this, JInventario.class);
                startActivity(intent);
            }
        });

        IVBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ETID.length()!=0){ Buscar("https://la-wea-redes.000webhostapp.com/hshaPHPs/buscarInventario.php?id_Articulo="+ETID.getText()); }
                else{ Toast.makeText(getApplicationContext(),"Ingrese un ID",Toast.LENGTH_SHORT).show(); }
            }
        });

        BEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ETNombre.length()!=0 & ETDescripcion.length()!=0 & ETCantidad.length()!=0){
                    ModArticulo("https://la-wea-redes.000webhostapp.com/hshaPHPs/modificarInventario.php?id_Articulo="+ ETID.getText().toString());
                }
                else{ Toast.makeText(getApplicationContext(),"Rellene todos los campos",Toast.LENGTH_SHORT).show(); }
            }
        });

        BEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(JresultadosInventario.this);
                alerta.setMessage("¿Desea eliminar el articulo?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                if(ETID.length()!=0){ Eliminar("https://la-wea-redes.000webhostapp.com/hshaPHPs/bajaInventario.php?id_Articulo="+ ETID.getText().toString()); }
                                else{ Toast.makeText(getApplicationContext(),"Llene los campos",Toast.LENGTH_SHORT).show(); }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Confirmar");
                titulo.show();
            }
        });

    }

    private void ModArticulo(String URL) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT).show();
            }
        }){
            //@Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("id_Articulo", (ETID.getText().toString()));
                parametros.put("nombre",(ETNombre.getText().toString()));
                parametros.put("descripcion",(ETDescripcion.getText().toString()));
                parametros.put("cantidad",(ETCantidad.getText().toString()));

                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Buscar(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        ETID.setText(jsonObject.getString("id_Articulo"));
                        ETNombre.setText(jsonObject.getString("nombre"));
                        ETCantidad.setText(jsonObject.getString("cantidad"));
                        ETDescripcion.setText(jsonObject.getString("descripcion"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No encontrado", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue= Volley.newRequestQueue(getApplication());
        requestQueue.add(jsonArrayRequest);
    }

    private void Eliminar(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "El producto fue eliminado", Toast.LENGTH_SHORT).show();
                ETID.setText("");
                ETNombre.setText("");
                ETCantidad.setText("");
                ETDescripcion.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT).show();
            }
        }){
            //@Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("id_Articulo",(ETID.getText().toString()));
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}