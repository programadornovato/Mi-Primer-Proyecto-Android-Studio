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
    var grabadora:MediaRecorder?=null
    var ruta:String?=null
    var imgGrabar:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgGrabar=findViewById(R.id.imgGrabar)

        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO), 1000)
        }

    }
    fun grabar(view : View){

        if(grabadora==null){
            ruta=getExternalStorageDirectory().getAbsolutePath().toString()+"/grabacion.mp3"
            grabadora=MediaRecorder()
            grabadora?.setAudioSource(MediaRecorder.AudioSource.MIC)
            grabadora?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            grabadora?.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            grabadora?.setOutputFile(ruta)
            try {
                grabadora?.prepare()
                grabadora?.start()
                imgGrabar?.setBackgroundColor(Color.RED)
                Toast.makeText(applicationContext, "Grabando...", Toast.LENGTH_SHORT).show()
            }catch (e:IOException){
                println(e)
            }

        }else{
            try {
                grabadora?.stop()
                grabadora?.release()
                imgGrabar?.setBackgroundColor(Color.BLACK)
                Toast.makeText(applicationContext, "Termino de grabar", Toast.LENGTH_SHORT).show()
            }catch (e:IOException){
                println(e)
            }
        }
    }
    fun reproducir(view: View){
        var mediaPlayer=MediaPlayer()
        try {
            mediaPlayer.setDataSource(ruta)
            mediaPlayer.prepare()
        }catch (e:IOException){
            println(e)
        }
        mediaPlayer.start()
        Toast.makeText(applicationContext, "Reproduciendo audio", Toast.LENGTH_SHORT).show()
    }

}