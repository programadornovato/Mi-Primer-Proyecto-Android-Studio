package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var bn:Button?=null
    private var bs:Button?=null
    private var tvr:TextView?=null
    val displayMetrics=DisplayMetrics()
    var alto=0
    var ancho=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bn=findViewById(R.id.btnNo)
        bs=findViewById(R.id.btnSi)
        tvr=findViewById(R.id.txtViewRespuesta)
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        alto=displayMetrics.heightPixels
        ancho=displayMetrics.widthPixels
    }
    fun clickNo(view:View){
        var randomX=(100..ancho-100).random().toFloat()
        var randomY=(100..alto-100).random().toFloat()
        bn?.x=randomX
        bn?.y=randomY
    }
    fun clickSi(view:View){
        tvr?.text="Sabia que caerias en mis brazos"
    }


}