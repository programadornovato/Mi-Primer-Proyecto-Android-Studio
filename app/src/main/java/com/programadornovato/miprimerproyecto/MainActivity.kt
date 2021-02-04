package com.programadornovato.miprimerproyecto

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private var txtURL:EditText?=null
    private var navegador:WebView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtURL=findViewById(R.id.txtURL)
        navegador=findViewById(R.id.navegador)

    }
    fun cargar(view: View){
        var url=txtURL?.text.toString()
        navegador?.clearCache(false)
        navegador?.settings?.javaScriptEnabled=true
        navegador?.loadUrl(url)
    }
}