package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var tp:EditText?=null
    var tvr:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tp=findViewById(R.id.txtPalindromo)
        tvr=findViewById(R.id.txtViewResultado)
    }

    fun validaPalindromo(viwe:View){
        var texto=tp?.text.toString()
        texto=texto.toLowerCase()
        texto=texto.replace("\\s".toRegex(),"")
        val longitud=texto.length
        var igual=true
        var cont=0
        for (i in longitud-1 downTo 0){
            if(texto[i]!=texto[cont]){
                igual=false
                break
            }
            cont++
        }
        if(igual==true){
            tvr?.text="Si humano si es un palindromo"
        }else{
            tvr?.text="Humano estupido no es palindromo"
        }
    }

}