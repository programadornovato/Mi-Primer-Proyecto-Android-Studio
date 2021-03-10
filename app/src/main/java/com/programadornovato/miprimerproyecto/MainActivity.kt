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
        view.isEnabled=false
    }
}