package com.programadornovato.miprimerproyecto

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun saludo(view: View){
        var texto=view.contentDescription.toString()
        if(texto=="Hola"){
            Toast.makeText(this,"¡¡Hola humano como estas!!",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"¡¡Adios humano te voy a extrañar!!",Toast.LENGTH_LONG).show()
        }
    }
}