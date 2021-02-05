package com.programadornovato.miprimerproyecto

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private var txtURL:EditText?=null
    private var navegador:WebView?=null
    private var errorPagina=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtURL=findViewById(R.id.txtURL)
        navegador=findViewById(R.id.navegador)
        navegador?.clearCache(false)
        navegador?.settings?.javaScriptEnabled=true

        navegador?.webViewClient = object : WebViewClient(){
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                errorPagina=true
                Toast.makeText(this@MainActivity,"Error al cargar: $error",Toast.LENGTH_LONG).show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                if(errorPagina==false){
                    Toast.makeText(this@MainActivity,"La pagina termino de cargar",Toast.LENGTH_LONG).show()
                }
            }
        }


    }
    fun cargar(view: View){
        errorPagina=false
        var url=txtURL?.text.toString()
        navegador?.loadUrl(url)
    }
}