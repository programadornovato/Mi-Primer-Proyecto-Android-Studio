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
    private var lvLenguajes:ListView?=null
    private var tvSeleccion:TextView?=null

    private val lenguajes = arrayOf("Kotlin","Java","C++","PHP","Javascript","C#","VB.Net")
    private val ranking = arrayOf( "1"     ,"5"   ,"2"  ,"6"  ,"2"         ,"3" ,"4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvLenguajes=findViewById(R.id.lvLenguajes)
        tvSeleccion=findViewById(R.id.tvSeleccion)

        var adaptador:ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.list_view_programadornovato,lenguajes)
        lvLenguajes?.adapter=adaptador

        lvLenguajes?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvSeleccion?.text="El ranking del lenguaje ${lvLenguajes?.getItemAtPosition(position)} es ${ranking[position]}"
            }

        }
    }

}