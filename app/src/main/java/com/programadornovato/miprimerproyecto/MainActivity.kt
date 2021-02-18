package com.programadornovato.miprimerproyecto

import android.content.Context
import android.content.SharedPreferences
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    var txtIdBuscar:EditText?=null
    var txtId:EditText?=null
    var txtNombre:EditText?=null
    var txtDireccion:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtIdBuscar=findViewById(R.id.txtIdBuscar)
        txtId=findViewById(R.id.txtId)
        txtNombre=findViewById(R.id.txtNombre)
        txtDireccion=findViewById(R.id.txtDireccion)
    }
    fun buscar(view: View){
        var buscarId=txtIdBuscar?.text.toString()
        var pref=getSharedPreferences(buscarId,Context.MODE_PRIVATE)
        var id=pref.getString("id","")
        var nombre=pref.getString("nombre","")
        var direccion=pref.getString("direccion","")
        if(id!!.length>0){
            Toast.makeText(this,"Se ha encontrado el registro",Toast.LENGTH_LONG).show()
            txtId?.setText(id)
            txtNombre?.setText(nombre)
            txtDireccion?.setText(direccion)
        }else{
            Toast.makeText(this,"No se ha encontrado el registro",Toast.LENGTH_LONG).show()
        }

    }
    fun guardar(view: View){
        var pref=getSharedPreferences(txtId?.text.toString(),Context.MODE_PRIVATE)
        var editor=pref.edit()
        editor.putString("id",txtId?.text.toString())
        editor.putString("nombre",txtNombre?.text.toString())
        editor.putString("direccion",txtDireccion?.text.toString())
        editor.commit()
        Toast.makeText(this,"Registro guardado exitosamente",Toast.LENGTH_LONG).show()
        txtId?.setText("")
        txtNombre?.setText("")
        txtDireccion?.setText("")
    }
}