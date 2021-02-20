package com.programadornovato.miprimerproyecto

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.*
import java.io.*

class MainActivity : AppCompatActivity() {
    var txtNombre:EditText?=null
    var txtContenido:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre=findViewById(R.id.txtNombre)
        txtContenido=findViewById(R.id.txtContenido)
    }
    fun guardar(view: View){
        val nombre=txtNombre?.text.toString()
        val contenido=txtContenido?.text.toString()
        try {
            val sd=Environment.getExternalStorageDirectory()
            val rutaArchivo= File(sd.path.toString(),nombre)
            val archivo=OutputStreamWriter(openFileOutput(nombre,Activity.MODE_PRIVATE))
            archivo.write(contenido)
            archivo.flush()
            archivo.close()
            Toast.makeText(this,"El archivo se guardo exitosamente",Toast.LENGTH_LONG).show()
            txtNombre?.setText("")
            txtContenido?.setText("")
        }catch (e:IOException){
            Toast.makeText(this,"Hubo un error al guardar "+e,Toast.LENGTH_LONG).show()
        }
    }
    fun buscar(view: View){
        val nombre=txtNombre?.text.toString()
        var contenido=""
        try {
        val sd=Environment.getExternalStorageDirectory()
        val rutaArchivo= File(sd.path.toString(),nombre)
        val archivo=InputStreamReader(openFileInput(nombre))
        val bf=BufferedReader(archivo)
        var linea=bf.readLine()
        while (linea!=null){
            contenido=contenido+linea+"\n"
            linea=bf?.readLine()
        }
        archivo.close()
        bf.close()
        txtContenido?.setText(contenido)
        }catch (e:IOException){
            Toast.makeText(this,"Hubo un error al guardar "+e,Toast.LENGTH_LONG).show()
        }

    }
}