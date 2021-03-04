package com.programadornovato.miprimerproyecto

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var listaAudios = arrayOfNulls<MediaPlayer>(6)
    var listaImagenes = arrayOfNulls<ImageView>(6)
    var audioBien: MediaPlayer?=null
    var audioError: MediaPlayer?=null
    var aleatorio=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaAudios[0]=MediaPlayer.create(this,R.raw.a0)
        listaAudios[1]=MediaPlayer.create(this,R.raw.a1)
        listaAudios[2]=MediaPlayer.create(this,R.raw.a2)
        listaAudios[3]=MediaPlayer.create(this,R.raw.a3)
        listaAudios[4]=MediaPlayer.create(this,R.raw.a4)
        listaAudios[5]=MediaPlayer.create(this,R.raw.a5)

        listaImagenes[0]=findViewById(R.id.i0)
        listaImagenes[1]=findViewById(R.id.i1)
        listaImagenes[2]=findViewById(R.id.i2)
        listaImagenes[3]=findViewById(R.id.i3)
        listaImagenes[4]=findViewById(R.id.i4)
        listaImagenes[5]=findViewById(R.id.i5)

        audioBien=MediaPlayer.create(this,R.raw.bien)
        audioError=MediaPlayer.create(this,R.raw.error)
    }
    fun emitirSonido(view: View){
        aleatorio=(0 .. 5).random()
        listaAudios[aleatorio]?.start()
    }
    fun clickFotoAnimal(view: View){
        if(view.id == listaImagenes[aleatorio]?.id){
            audioBien?.start()
        }else{
            audioError?.start()
        }
    }
}