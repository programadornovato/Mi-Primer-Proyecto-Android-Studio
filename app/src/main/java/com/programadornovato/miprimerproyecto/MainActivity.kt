package com.programadornovato.miprimerproyecto

import android.Manifest
import android.content.Context
import android.content.Intent
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
import android.os.CountDownTimer
import android.os.Environment.getExternalStorageDirectory
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var drawView:DrawView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawView= DrawView(this)
        drawView?.setBackgroundColor(Color.WHITE)
        setContentView(drawView)
        object : CountDownTimer(1000000L,100L){
            override fun onFinish() {
                this.cancel()
            }

            override fun onTick(millisUntilFinished: Long) {
                drawView!!.posX+=10f
                drawView!!.posY+=10f
                drawView!!.invalidate()
            }

        }.start()
    }
}