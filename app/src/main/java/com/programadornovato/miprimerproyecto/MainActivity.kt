package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
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

    private var saldo=100.0
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
            tvVerSaldo?.text="Humano tu saldo es de ${saldo}"
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
    fun btnOK(view:View){
        tvVerSaldo?.visibility=View.INVISIBLE
        txtIngresar?.visibility=View.INVISIBLE
        txtRetirar?.visibility=View.INVISIBLE
        if(rbVerSaldo?.isChecked()==true){
            tvVerSaldo?.text="Humano tu saldo es de $saldo"
        }
        if(rbIngresar?.isChecked()==true){
            var ingresar=txtIngresar?.text.toString().toDouble()
            saldo=saldo+ingresar
            tvVerSaldo?.text="Humano tu saldo es de $saldo"
            tvVerSaldo?.visibility=View.VISIBLE
            Toast.makeText(this,"Humano tu operacion se realizo de forma exitos",Toast.LENGTH_LONG).show()
        }
        if(rbRetirar?.isChecked()==true){
            var retirar=txtRetirar?.text.toString().toDouble()
            if(saldo-retirar < 0.0){
                tvVerSaldo?.visibility=View.VISIBLE
                tvVerSaldo?.text="Humano pillin no tienes tanto dinero"
            }else{
                saldo=saldo-retirar
                tvVerSaldo?.text="Humano tu saldo es de $saldo"
                tvVerSaldo?.visibility=View.VISIBLE
                Toast.makeText(this,"Humano tu operacion se realizo de forma exitos",Toast.LENGTH_LONG).show()
            }

        }
        if(rbSalir?.isChecked()==true){
            tvVerSaldo?.visibility=View.VISIBLE
            tvVerSaldo?.text="Adios humano"
            finish()
            System.exit(0)
        }

    }
}