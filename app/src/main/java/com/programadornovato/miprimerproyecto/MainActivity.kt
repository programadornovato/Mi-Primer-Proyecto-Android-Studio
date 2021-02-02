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
    private var chKotlin:CheckBox?=null
    private var chJava:CheckBox?=null
    private var chC:CheckBox?=null
    private var chPHP:CheckBox?=null
    private var tvSeleccion:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chKotlin=findViewById(R.id.chKotlin)
        chJava=findViewById(R.id.chJava)
        chC=findViewById(R.id.chC)
        chPHP=findViewById(R.id.chPHP)
        tvSeleccion=findViewById(R.id.tvSeleccion)

    }
    fun accion(view: View){
        var seleccion=""
        if(chKotlin?.isChecked==true){
            seleccion=seleccion+"Usted selecciono ${chKotlin?.text}\n"
        }
        if(chJava?.isChecked==true){
            seleccion=seleccion+"Usted selecciono ${chJava?.text}\n"
        }
        if(chC?.isChecked==true){
            seleccion=seleccion+"Usted selecciono ${chC?.text}\n"
        }
        if(chPHP?.isChecked==true){
            seleccion=seleccion+"Usted selecciono ${chPHP?.text}\n"
        }
        if(seleccion.isEmpty()==true){
            tvSeleccion?.text="Humano seleccionar un lenguaje!!!!"
        }else{
            tvSeleccion?.text=seleccion
        }

    }

}