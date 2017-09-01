package rojas.carlos.desktop_watch

import android.app.Activity
import android.os.Handler
import java.lang.Runnable
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manejador = Handler()
        val ejecutar = object : Runnable {
            override fun run() {
                var calendario = GregorianCalendar.getInstance(TimeZone.getTimeZone("America/Bogota"))
                val arregloMeses = arrayOf("Enero", "Febrero", "Marzo",
                        "Abril", "Mayo", "Junio",
                        "Julio", "Agosto", "Septiembre",
                        "Octubre", "Noviembre", "Diciembre")
                var mes = calendario.get(Calendar.MONTH)
                var dia = calendario.get(Calendar.DAY_OF_MONTH)
                var año = calendario.get(Calendar.YEAR)
                var hora = calendario.get(Calendar.HOUR_OF_DAY)
                var minutos:Int = calendario.get(Calendar.MINUTE)
                var segundos = calendario.get(Calendar.SECOND)
                var cadenaFecha = StringBuilder().append(dia).append(" de ").
                        append(arregloMeses[mes]).append(" de ").
                        append(año).toString()
                var cadenaHora = StringBuilder().
                        append( String.format("%02d", hora)).append(":").
                        append(String.format("%02d",minutos)).append(":").
                        append(String.format("%02d",segundos)).toString()
                textoClock.setText(cadenaFecha.toCharArray(), 0, cadenaFecha.length)
                textoHoras.setText(cadenaHora.toCharArray(), 0, cadenaHora.length)
                Log.e("Mensaje de CRRC", calendario.toString())
                manejador.postDelayed(this, 500)
            }
        }
        manejador.postDelayed(ejecutar,500)
    }
}
