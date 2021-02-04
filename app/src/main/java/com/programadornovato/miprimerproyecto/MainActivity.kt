package com.programadornovato.miprimerproyecto

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private var txtDato:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDato=findViewById(R.id.txtDato)

    }
    fun envia(view:View){
        var dato=txtDato?.text.toString()
        var intento=Intent(this,ActivityRecibe::class.java)
        intento.putExtra("dato",dato)
        startActivity(intento)
    }
}