package com.programadornovato.miprimerproyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var tlTabla:TableLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tlTabla=findViewById(R.id.tlTabla)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)
        for (i in 0 .. 35){
            val registro=LayoutInflater.from(this).inflate(R.layout.row_table_pn,null,false)
            val tv0=registro.findViewById<View>(R.id.tv0) as TextView
            val tv1=registro.findViewById<View>(R.id.tv1) as TextView
            val tv2=registro.findViewById<View>(R.id.tv2) as TextView
            tv0?.text= ((i+1)*1).toString()
            tv1?.text= ((i+1)*2).toString()
            tv2?.text= ((i+1)*3).toString()
            tlTabla?.addView(registro)
        }
    }
}