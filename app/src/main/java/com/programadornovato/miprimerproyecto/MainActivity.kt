package com.programadornovato.miprimerproyecto

import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    var txtNombre:EditText?=null
    var txtApellido:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)

        var pref=getSharedPreferences("datos_persona",Context.MODE_PRIVATE)
        var nombre=pref.getString("nombre","")
        txtNombre?.setText(nombre)
        var apellido=pref.getString("apellido","")
        txtApellido?.setText(apellido)

    }
    fun guardar(view: View){
        var pref=getSharedPreferences("datos_persona",Context.MODE_PRIVATE)
        var editor=pref.edit()
        editor.putString("nombre",txtNombre?.text.toString())
        editor.putString("apellido",txtApellido?.text.toString())
        editor.commit()
        Toast.makeText(this,"Se ha guardado exitosamente",Toast.LENGTH_LONG).show()
    }
}