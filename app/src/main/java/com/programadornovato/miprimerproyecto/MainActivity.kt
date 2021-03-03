package com.programadornovato.miprimerproyecto

import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var sp:SoundPool?=null
    var sonidoReproducir=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp= SoundPool(1,AudioManager.STREAM_MUSIC,1)
        sonidoReproducir=sp?.load(this,R.raw.mario_vida,1)!!
    }
    fun reproduceSoundPool(view:View){
        sp?.play(sonidoReproducir,1f,1f,1,0,1f)
    }
    fun reproducirMediaPlayer(view: View){
        val mp=MediaPlayer.create(this,R.raw.mario_muere)
        mp.start()
    }
}