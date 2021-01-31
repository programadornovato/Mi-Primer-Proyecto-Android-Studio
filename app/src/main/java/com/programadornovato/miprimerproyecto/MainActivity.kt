package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private var txtPrecio:EditText?=null
    private var tvLista:TextView?=null
    private var tvTotal:TextView?=null

    private var contador=0
    private var listaProductos=ArrayList<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPrecio=findViewById(R.id.txtPrecio)
        tvLista=findViewById(R.id.tvLista)
        tvTotal=findViewById(R.id.tvTotal)
    }
    fun agregar(view: View){
        var precio=txtPrecio?.text.toString().toDouble()
        listaProductos.add(precio)
        tvLista?.text=tvLista?.text.toString()+"\n"+"Producto ${contador+1}=%.2f".format(precio)
        contador++
        txtPrecio?.setText("")
        var total=0.0
        listaProductos.forEach{
            total=total+it
        }
        tvTotal?.text="Total=%.2f".format(total)
    }

}