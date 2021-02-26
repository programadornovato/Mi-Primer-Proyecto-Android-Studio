package com.programadornovato.miprimerproyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var btnPerro:Button?=null
    var btnGato:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPerro=findViewById(R.id.btnPerro)
        btnGato=findViewById(R.id.btnGato)
    }
    fun clickPerro(view: View){
        btnPerro?.visibility=View.GONE
        btnGato?.visibility=View.VISIBLE
    }
    fun clickGato(view: View){
        btnPerro?.visibility=View.VISIBLE
        btnGato?.visibility=View.GONE
    }
}