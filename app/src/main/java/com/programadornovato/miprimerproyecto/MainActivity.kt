package com.programadornovato.miprimerproyecto

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    var txtTexto:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtTexto=findViewById(R.id.txtTexto)
        if(existeArchivo(fileList(),"texto.txt")){
            var contenido=""
            val archivo=InputStreamReader(openFileInput("texto.txt"))
            val bf=BufferedReader(archivo)
            var linea=bf.readLine()
            while (linea!=null){
                contenido=contenido+linea+"\n"
                linea=bf.readLine()
            }
            txtTexto?.setText(contenido)
        }
    }
    fun guardar(view: View){
        val archivo=OutputStreamWriter(openFileOutput("texto.txt",Activity.MODE_PRIVATE))
        archivo.write(txtTexto?.text.toString())
        archivo.flush()
        archivo.close()
        finish()
    }
    fun existeArchivo(archivos:Array<String>,archivo:String):Boolean{
        archivos.forEach {
            if(archivo==it){
                return true
            }
        }
        return false
    }
}