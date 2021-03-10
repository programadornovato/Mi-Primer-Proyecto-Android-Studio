package com.programadornovato.miprimerproyecto

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.media.SoundPool
import android.os.Bundle
import android.os.Environment.getExternalStorageDirectory
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var img1:ImageView?=null
    var img2:ImageView?=null
    var img3:ImageView?=null
    var img4:ImageView?=null
    var img5:ImageView?=null
    var img6:ImageView?=null
    var img7:ImageView?=null
    var img8:ImageView?=null
    var img9:ImageView?=null

    var imgTurnoX:ImageView?=null
    var imgTurnoO:ImageView?=null
    var turno="x"
    var matrizGanadora= arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9),
            intArrayOf(1,4,7),
            intArrayOf(2,5,8),
            intArrayOf(3,6,9),
            intArrayOf(1,5,9),
            intArrayOf(3,5,7)
    )
    var posicionesX=IntArray(5)
    var posicionesO=IntArray(5)
    var gandor=""
    var contadorX=0
    var contadorO=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1=findViewById(R.id.img1)
        img2=findViewById(R.id.img2)
        img3=findViewById(R.id.img3)
        img4=findViewById(R.id.img4)
        img5=findViewById(R.id.img5)
        img6=findViewById(R.id.img6)
        img7=findViewById(R.id.img7)
        img8=findViewById(R.id.img8)
        img9=findViewById(R.id.img9)
        imgTurnoX=findViewById(R.id.imgTurnoX)
        imgTurnoO=findViewById(R.id.imgTurnoO)
        imgTurnoX?.setBackgroundColor(Color.RED)

    }
    fun clickImagen(view: View){
        when(view.id){
            R.id.img1->{
                if(turno=="x"){
                    posicionesX[contadorX]=1
                    contadorX++
                }else{
                    posicionesO[contadorO]=1
                    contadorO++
                }
            }
            R.id.img2->{
                if(turno=="x"){
                    posicionesX[contadorX]=2
                    contadorX++
                }else{
                    posicionesO[contadorO]=2
                    contadorO++
                }
            }
            R.id.img3->{
                if(turno=="x"){
                    posicionesX[contadorX]=3
                    contadorX++
                }else{
                    posicionesO[contadorO]=3
                    contadorO++
                }
            }
            R.id.img4->{
                if(turno=="x"){
                    posicionesX[contadorX]=4
                    contadorX++
                }else{
                    posicionesO[contadorO]=4
                    contadorO++
                }
            }
            R.id.img5->{
                if(turno=="x"){
                    posicionesX[contadorX]=5
                    contadorX++
                }else{
                    posicionesO[contadorO]=5
                    contadorO++
                }
            }
            R.id.img6->{
                if(turno=="x"){
                    posicionesX[contadorX]=6
                    contadorX++
                }else{
                    posicionesO[contadorO]=6
                    contadorO++
                }
            }
            R.id.img7->{
                if(turno=="x"){
                    posicionesX[contadorX]=7
                    contadorX++
                }else{
                    posicionesO[contadorO]=7
                    contadorO++
                }
            }
            R.id.img8->{
                if(turno=="x"){
                    posicionesX[contadorX]=8
                    contadorX++
                }else{
                    posicionesO[contadorO]=8
                    contadorO++
                }
            }
            R.id.img9->{
                if(turno=="x"){
                    posicionesX[contadorX]=9
                    contadorX++
                }else{
                    posicionesO[contadorO]=9
                    contadorO++
                }
            }
        }
        if(turno=="x"){
            view.setBackgroundResource(R.drawable.gato_x)
            imgTurnoO?.setBackgroundColor(Color.RED)
            imgTurnoX?.setBackgroundColor(Color.WHITE)
            turno="o"
        }else{
            view.setBackgroundResource(R.drawable.gato_o)
            imgTurnoX?.setBackgroundColor(Color.RED)
            imgTurnoO?.setBackgroundColor(Color.WHITE)
            turno="x"
        }
        for (i in 0 until contadorX){
            var gano=true
            var altoMatriz=matrizGanadora.size
            for(j in 0 until  altoMatriz){
                gano=coincideGanador(matrizGanadora[j],posicionesX)
                if(gano==true){
                    Toast.makeText(this,"Gano X",Toast.LENGTH_LONG).show()
                    gandor="x"
                    dibujaGanador()
                    deshabilitar()
                    break
                }
            }
            if(gano==true){
                break
            }
        }
        for (i in 0 until contadorO){
            var gano=true
            var altoMatriz=matrizGanadora.size
            for(j in 0 until  altoMatriz){
                gano=coincideGanador(matrizGanadora[j],posicionesO)
                if(gano==true){
                    Toast.makeText(this,"Gano O",Toast.LENGTH_LONG).show()
                    gandor="o"
                    dibujaGanador()
                    deshabilitar()
                    break
                }
            }
            if(gano==true){
                break
            }
        }
        view.isEnabled=false
    }
    fun coincideGanador(registroGranador:IntArray,posiciones:IntArray):Boolean{
        for(i in 0 until 3){
            if(registroGranador[i]!=posiciones[i]){
                return false
            }
        }
        return true
    }
    fun dibujaGanador(){
        if(gandor=="x"){
            for (i in 0 until contadorX){
                if(posicionesX[i]==1){
                    img1?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==2){
                    img2?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==3){
                    img3?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==4){
                    img4?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==5){
                    img5?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==6){
                    img6?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==7){
                    img7?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==8){
                    img8?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==9){
                    img9?.setBackgroundColor(Color.BLUE)
                }
            }
        }else{
            for (i in 0 until contadorO){
                if(posicionesO[i]==1){
                    img1?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==2){
                    img2?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==3){
                    img3?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==4){
                    img4?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==5){
                    img5?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==6){
                    img6?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==7){
                    img7?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==8){
                    img8?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==9){
                    img9?.setBackgroundColor(Color.BLUE)
                }
            }
        }
    }
    fun deshabilitar(){
        img1?.isEnabled=false
        img2?.isEnabled=false
        img3?.isEnabled=false
        img4?.isEnabled=false
        img5?.isEnabled=false
        img6?.isEnabled=false
        img7?.isEnabled=false
        img8?.isEnabled=false
        img9?.isEnabled=false
    }
    fun reiniciar(view: View){
        val intento=intent
        finish()
        startActivity(intento)
    }
}