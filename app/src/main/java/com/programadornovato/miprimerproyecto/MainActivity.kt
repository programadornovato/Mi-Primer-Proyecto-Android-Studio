package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    var txtViewResultado:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtViewResultado=findViewById(R.id.txtViewResultado)
    }
    fun calcular(view:View){
        var txtLitrosBorracho:EditText=findViewById(R.id.txtLitrosBorracho)
        var txtDiametroVaso:EditText=findViewById(R.id.txtDiametroVaso)
        var txtAlturaVaso:EditText=findViewById(R.id.txtAlturaVaso)
        var txtVasosCervesa:EditText=findViewById(R.id.txtVasosCervesa)
        var dAlturaVaso=txtAlturaVaso.text.toString().toDouble()
        var d=txtDiametroVaso.text.toString().toDouble()
        var r=d/2
        var v= PI*r*2*dAlturaVaso
        var mililitrosTomados=v*txtVasosCervesa.text.toString().toDouble()
        var dLitrosBorracho=txtLitrosBorracho.text.toString().toDouble()
        var limiteVasos=dLitrosBorracho*1000/v
        limiteVasos=limiteVasos.round(2)
        if(mililitrosTomados>dLitrosBorracho*1000){
            txtViewResultado?.text="Humano ya estas borracho tu limite es de $limiteVasos vasos"
        }else{
            txtViewResultado?.text="Humano aun no estas borracho tu limite es de $limiteVasos vasos"
        }
    }
    fun Double.round(decimal: Int):Double{
        var multiplicador=1.0
        repeat(decimal){multiplicador*=10}
        return round(this*multiplicador)/multiplicador
    }


}