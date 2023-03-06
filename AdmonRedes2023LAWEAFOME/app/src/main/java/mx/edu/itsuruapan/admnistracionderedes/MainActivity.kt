package mx.edu.itsuruapan.admnistracionderedes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    //Declarar los objetos

    private var ETEmail: EditText? = null
    private var ETContra: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_k_main)

        ETEmail = findViewById<View>(R.id.ETgUser) as EditText
        ETContra = findViewById<View>(R.id.ETgPass) as EditText


    }

    //Método para validar usuarios
    private fun validarUsuario(URL: String) {
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, URL,
            Response.Listener { response ->
                if (!response.isEmpty()) {
                    val oth = Intent(applicationContext, menu::class.java)
                    startActivity(oth)
                    ETContra?.setText("");
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Usuario o contraseña incorrecta",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this@MainActivity,
                    error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val parametros: MutableMap<String, String> = HashMap()
                parametros["email"] = ETEmail!!.text.toString()
                parametros["contrasena"] = ETContra!!.text.toString()
                val value =  credenciales_Usuario()
                value.setUsuarioIngresado("")
                value.setUsuarioIngresado(ETEmail!!.text.toString())
                return parametros

            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

    //Metodo del boton, llama a validarUsuario()
    fun MetodoIngresar(view: View?) {
        //pasar los valores de ETUser y ETPass a variables
        val User = ETEmail!!.text.toString()
        val Pass = ETContra!!.text.toString()

        //Verifica que los campos tengan algun valor
        if (User.length != 0 && Pass.length != 0) {
            validarUsuario("https://la-wea-redes.000webhostapp.com/hshaPHPs/validarUsuario.php")
        } //Llave del if
        else {
            Toast.makeText(this, "Ingrese usuario y contraseña", Toast.LENGTH_LONG).show()
        }
    }

    fun IrARegistrar(view: View?) {
        val oth = Intent(applicationContext, JAgregarUsuario::class.java)
        startActivity(oth)
    }
}