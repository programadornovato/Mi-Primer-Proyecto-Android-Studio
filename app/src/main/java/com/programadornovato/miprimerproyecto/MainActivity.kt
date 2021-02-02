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
    private var spLenguajes:Spinner?=null
    private var tvSeleccion:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spLenguajes=findViewById(R.id.spLenguajes)
        tvSeleccion=findViewById(R.id.tvSeleccion)

        val listaLenguajes= arrayOf("Seleccione un lenguaje","Kotlin","Java","C++","PHP")

        var adaptador:ArrayAdapter<String> = ArrayAdapter(this,R.layout.spinner_items_programadornovato,listaLenguajes)
        spLenguajes?.adapter=adaptador

        spLenguajes?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position>0){
                    tvSeleccion?.text="Seleccionaste "+spLenguajes?.getSelectedItem().toString()
                }else{
                    tvSeleccion?.text="No haz seleccionado ningun lenguaje de programacion"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                tvSeleccion?.text="No haz seleccionado ningun lenguaje de programacion"
            }

        }

    }

}