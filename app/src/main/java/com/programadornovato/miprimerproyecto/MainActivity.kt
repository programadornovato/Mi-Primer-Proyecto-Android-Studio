package com.programadornovato.miprimerproyecto

import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    var txtFecha:EditText?=null
    var btnFecha:ImageButton?=null
    var dpFecha:DatePicker?=null

    var txtHora:EditText?=null
    var btnHora:ImageButton?=null
    var tpHora:TimePicker?=null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFecha=findViewById(R.id.txtFecha)
        btnFecha=findViewById(R.id.btnFecha)
        dpFecha=findViewById(R.id.dpFecha)

        txtFecha?.setText(getFechaDtePicker())

        dpFecha?.setOnDateChangedListener{
            dpFecha,anio,mes,dia->
            txtFecha?.setText(getFechaDtePicker())
            dpFecha?.visibility=View.GONE
        }

        txtHora=findViewById(R.id.txtHora)
        btnHora=findViewById(R.id.btnHora)
        tpHora=findViewById(R.id.tpHora)

        txtHora?.setText(getHoraTimePicker())

        tpHora?.setOnClickListener { tpHora->
            txtHora?.setText(getHoraTimePicker())
            tpHora?.visibility=View.GONE
        }

    }
    fun getHoraTimePicker():String{
        var hora=tpHora?.currentHour.toString().padStart(2,'0')
        var minutos=tpHora?.currentMinute.toString().padStart(2,'0')
        return hora+":"+minutos
    }
    fun mostrarReloj(view: View){
        tpHora?.visibility=View.VISIBLE
    }
    fun getFechaDtePicker():String{
        var dia=dpFecha?.dayOfMonth.toString().padStart(2,'0')
        var mes=(dpFecha!!.month+1).toString().padStart(2,'0')
        var anio=dpFecha?.year.toString().padStart(4,'0')
        return dia+"/"+mes+"/"+anio
    }
    fun muestraCalendario(view: View){
        dpFecha?.visibility=View.VISIBLE
    }
}