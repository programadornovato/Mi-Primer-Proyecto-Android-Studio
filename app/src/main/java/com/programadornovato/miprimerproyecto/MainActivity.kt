package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private var rbVerSaldo:RadioButton?=null
    private var rbIngresar:RadioButton?=null
    private var rbRetirar:RadioButton?=null
    private var rbSalir:RadioButton?=null

    private var tvVerSaldo:TextView?=null

    private var txtIngresar:EditText?=null
    private var txtRetirar:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rbVerSaldo=findViewById(R.id.rbVerSaldo)
        rbIngresar=findViewById(R.id.rbIngresar)
        rbRetirar=findViewById(R.id.rbRetirar)
        rbSalir=findViewById(R.id.rbSalir)

        tvVerSaldo=findViewById(R.id.tvVerSaldo)

        txtIngresar=findViewById(R.id.txtIngresar)
        txtRetirar=findViewById(R.id.txtRetirar)
    }
    fun accion(view: View){
        tvVerSaldo?.visibility=View.INVISIBLE
        txtIngresar?.visibility=View.INVISIBLE
        txtRetirar?.visibility=View.INVISIBLE
        if(rbVerSaldo?.isChecked()==true){
            tvVerSaldo?.visibility=View.VISIBLE
            tvVerSaldo?.text="Humano tu saldo es de "
        }
        if(rbIngresar?.isChecked()==true){
            txtIngresar?.visibility=View.VISIBLE
        }
        if(rbRetirar?.isChecked()==true){
            txtRetirar?.visibility=View.VISIBLE
        }
        if(rbSalir?.isChecked()==true){
            tvVerSaldo?.visibility=View.VISIBLE
            tvVerSaldo?.text="Adios humano"
        }
    }

}