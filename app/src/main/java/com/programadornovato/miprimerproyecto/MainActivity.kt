package com.programadornovato.miprimerproyecto

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.webkit.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private var txtTiempo:EditText?=null
    private var tvCuentaAtras:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTiempo=findViewById(R.id.txtTiempo)
        tvCuentaAtras=findViewById(R.id.tvCuentaAtras)
    }
    fun play(view: View){
        var tiempoSegundos=txtTiempo?.text.toString().toLong()
        var tiempoMilisegundos=tiempoSegundos*1000
        object : CountDownTimer(tiempoMilisegundos,1000){
            override fun onFinish() {
                val notificacion=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
                val r=RingtoneManager.getRingtone(this@MainActivity,notificacion)
                r.play()
                this.cancel()
            }

            override fun onTick(millisUntilFinished: Long) {
                val tiempoSegundos=(millisUntilFinished/1000).toInt()+1
                tvCuentaAtras?.text=tiempoSegundos.toString().padStart(2,'0')
            }
        }.start()
    }
}