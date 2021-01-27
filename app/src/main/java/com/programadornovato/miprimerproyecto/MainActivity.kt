package com.programadornovato.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var calificacion=8
        println("La calificacion del alumno es: $calificacion")
        if(calificacion>=0 && calificacion<6){
            println("El estudiante se ch1ng0")
        }else if(calificacion>=6 && calificacion<=9){
            println("El alumno aprobo")
        }else if(calificacion==10){
            println("El alumno es un 1ng0n")
        }else{
            println("Esta calificacion no es valida")
        }
    }

}