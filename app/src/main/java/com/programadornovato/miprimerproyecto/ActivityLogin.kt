package com.programadornovato.miprimerproyecto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class ActivityLogin : AppCompatActivity() {
    var txtUsu: EditText?=null
    var txtPass: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtUsu=findViewById(R.id.txtUsu)
        txtPass=findViewById(R.id.txtPass)

    }
    fun login(view:View){
        var pref=getSharedPreferences(txtUsu?.text.toString(),Context.MODE_PRIVATE)
        var pass=pref.getString("pass","")
        if(pass==txtPass?.text.toString()){
            Toast.makeText(this,"El usuario se ha logueado",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_LONG).show()
        }
        txtUsu?.setText("")
        txtPass?.setText("")
    }
    fun atras(view: View){
        val mainActivity= Intent(this,MainActivity::class.java)
        startActivity(mainActivity)
    }
}