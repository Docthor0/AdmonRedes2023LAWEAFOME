package mx.edu.itsuruapan.admnistracionderedes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class JaddConfiguraciones extends AppCompatActivity {

    Button BAtras;
    Button BNuevo;
    EditText ETNombre;
    EditText ETDescripcion;

    RequestQueue requestQueue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_add_configuraciones);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BAtras=(Button)findViewById(R.id.botonReturn7AC);
        BNuevo=(Button)findViewById(R.id.botonAgregarConfigAC);

        ETNombre=(EditText)findViewById(R.id.campoNombreConfigAC);
        ETDescripcion=(EditText)findViewById(R.id.campoDescripcionConfigAC);

        BAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JaddConfiguraciones.this, JConfiguraciones.class);
                startActivity(intent);
            }
        });

        BNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El if verifica que todos los edit Text tengan datos para poder proceder
                if(ETNombre.length()!=0 & ETDescripcion.length()!=0){
                    NuevoArticulo("https://la-wea-redes.000webhostapp.com/hshaPHPs/insertarConfiguracion.php");
                }
                else{ Toast.makeText(getApplicationContext(),"Rellene todos los campos",Toast.LENGTH_SHORT).show(); }
            }
        });





    }

    private void NuevoArticulo(String URL) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                ETNombre.setText("");
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
                parametros.put("nombre",(ETNombre.getText().toString()));
                parametros.put("descripcion",(ETDescripcion.getText().toString()));
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}