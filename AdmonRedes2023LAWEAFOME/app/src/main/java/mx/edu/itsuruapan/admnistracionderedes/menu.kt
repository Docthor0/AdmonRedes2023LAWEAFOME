package mx.edu.itsuruapan.admnistracionderedes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_k_menu)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    fun IrAInventario(view: View?) {
        val oth = Intent(applicationContext, JInventario::class.java)
        startActivity(oth)
    }
    fun IrADispositivos(view: View?) {
        val oth = Intent(applicationContext, JDispositivo::class.java)
        startActivity(oth)
    }
    fun IrAFallas(view: View?) {
        val oth = Intent(applicationContext, JFallas::class.java)
        startActivity(oth)
    }
    fun IrAPlanes(view: View?) {
        val oth = Intent(applicationContext, JPlanes::class.java)
        startActivity(oth)
    }
    fun IrAConfiguracion(view: View?) {
        val oth = Intent(applicationContext, JConfiguraciones::class.java)
        startActivity(oth)
    }
}