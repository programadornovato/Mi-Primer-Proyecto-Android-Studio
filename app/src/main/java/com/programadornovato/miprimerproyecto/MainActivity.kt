package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var tn1:EditText?=null
    var tn2:EditText?=null
    var tvr:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tn1=findViewById(R.id.txtNumero1)
        tn2=findViewById(R.id.txtNumero2)
        tvr=findViewById(R.id.txtViewResultado)
        //tvr?.text="5"
    }
    fun suma(view: View){
        val num1String=tn1?.text.toString()
        val num2String=tn2?.text.toString()

        val num1Int=num1String.toInt()
        val num2Int=num2String.toInt()

        val resultadoInt=num1Int+num2Int
        tvr?.text=resultadoInt.toString()
    }

}