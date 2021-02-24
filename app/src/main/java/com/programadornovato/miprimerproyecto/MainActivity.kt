package com.programadornovato.miprimerproyecto

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.*
import java.io.*

class MainActivity : AppCompatActivity() {
    var llLogin:LinearLayout?=null
    var llRegistro:LinearLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llLogin=findViewById(R.id.llLogin)
        llRegistro=findViewById(R.id.llRegistro)
    }
    fun clickLoginRegistro(view: View){
        val nombreCompleto=resources.getResourceName(view.id)
        println(nombreCompleto)
        val nombre=nombreCompleto.substring(nombreCompleto.lastIndexOf("/")+1)
        if(nombre=="rdLogin"){
            llLogin?.visibility=View.VISIBLE
            llRegistro?.visibility=View.GONE
        }else if(nombre=="rdRegistro"){
            llLogin?.visibility=View.GONE
            llRegistro?.visibility=View.VISIBLE
        }
    }
}