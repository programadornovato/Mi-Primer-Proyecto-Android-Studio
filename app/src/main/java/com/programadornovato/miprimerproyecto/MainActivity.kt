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
    var matriz = arrayOf(
            arrayOf(0,1,2),
            arrayOf(3,4,5),
            arrayOf(6,7,8)
    )
    var tlTabla:TableLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tlTabla=findViewById(R.id.tlTabla)
        tlTabla?.removeAllViews()
        for (i in (0 until matriz.count())){
            val registro = LayoutInflater.from(this).inflate(R.layout.row_table_pn,null,false)
            val tv0=registro.findViewById<View>(R.id.tv0) as TextView
            val tv1=registro.findViewById<View>(R.id.tv1) as TextView
            val tv2=registro.findViewById<View>(R.id.tv2) as TextView
            tv0.text=matriz[i][0].toString()
            tv1.text=matriz[i][1].toString()
            tv2.text=matriz[i][2].toString()
            tlTabla?.addView(registro)
        }
    }
}