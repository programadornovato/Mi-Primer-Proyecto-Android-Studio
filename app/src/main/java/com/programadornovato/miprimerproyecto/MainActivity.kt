package com.programadornovato.miprimerproyecto

import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var txtSegundos:EditText?=null
    private var txtMinutos:EditText?=null
    private var txtHoras:EditText?=null
    private var tvCuentaAtras:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtSegundos=findViewById(R.id.txtSegundos)
        txtMinutos=findViewById(R.id.txtMinutos)
        txtHoras=findViewById(R.id.txtHoras)
        tvCuentaAtras=findViewById(R.id.tvCuentaAtras)
    }
    fun play(view: View){
        val seg=txtSegundos?.text.toString().toLong()*1000
        val min=txtMinutos?.text.toString().toLong()*60*1000
        val hor=txtHoras?.text.toString().toLong()*60*60*1000
        var tiempoMilisegundos=seg+min+hor
        object : CountDownTimer(tiempoMilisegundos,1000){
            override fun onFinish() {
                val notificacion=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
                val r=RingtoneManager.getRingtone(this@MainActivity,notificacion)
                r.play()
                this.cancel()
            }

            override fun onTick(millisUntilFinished: Long) {
                var tiempoSegundos=(millisUntilFinished/1000).toInt()+1
                val horas=tiempoSegundos/3600
                tiempoSegundos=tiempoSegundos%3600
                val min=tiempoSegundos/60
                tiempoSegundos=tiempoSegundos%60
                tvCuentaAtras?.text=horas.toString().padStart(2,'0')+":"+min.toString().padStart(2,'0')+":"+tiempoSegundos.toString().padStart(2,'0')
            }
        }.start()
    }
}