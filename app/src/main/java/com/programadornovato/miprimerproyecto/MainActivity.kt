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
    private var txtPrecio:EditText?=null
    private var tvLista:TextView?=null
    private var tvTotal:TextView?=null

    private var txtPago:EditText?=null
    private var tvCambio:TextView?=null

    private var contador=0
    private var listaProductos=ArrayList<Double>()
    private var total=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPrecio=findViewById(R.id.txtPrecio)
        tvLista=findViewById(R.id.tvLista)
        tvTotal=findViewById(R.id.tvTotal)
        txtPago=findViewById(R.id.txtPago)
        tvCambio=findViewById(R.id.tvCambio)
    }
    fun agregar(view: View){
        var precio=txtPrecio?.text.toString().toDouble()
        listaProductos.add(precio)
        tvLista?.text=tvLista?.text.toString()+"\n"+"Producto ${contador+1}=%.2f".format(precio)
        contador++
        txtPrecio?.setText("")
        total=0.0
        listaProductos.forEach{
            total=total+it
        }
        tvTotal?.text="Total=%.2f".format(total)
    }
    fun pagar(view: View){
        var pago=txtPago?.text.toString().toDouble()
        var cambio=pago-total
        var centavos=cambio-cambio.toInt()
        if(centavos>0.0){
            val dialogo:AlertDialog.Builder=AlertDialog.Builder(this)
            dialogo.setTitle("¿Deseas donar tus centavos?")
            dialogo.setMessage("Haz click para donar %.2f".format(centavos)+" centavos")
            dialogo.setPositiveButton("Si"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"Gracias por donar %.2f".format(centavos)+" centavos",Toast.LENGTH_LONG).show()
                tvCambio?.text="Su cambio es de %.2f".format(cambio-centavos)
            }
            dialogo.setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"Gracias por nada por favor no regreses",Toast.LENGTH_LONG).show()
                tvCambio?.text="Su cambio es de %.2f".format(cambio)
            }
            val alerta:AlertDialog=dialogo.create()
            alerta.setCanceledOnTouchOutside(false)
            alerta.show()
        }else{
            tvCambio?.text="Su cambio es de %.2f".format(cambio)
        }
    }

}