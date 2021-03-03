package com.programadornovato.miprimerproyecto

import android.content.Context
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
    var txtPosicion:EditText?=null
    var sm:SensorManager?=null
    var sa:Sensor?=null
    var SEL: SensorEventListener?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtPosicion=findViewById(R.id.txtPosicion)

        sm=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sa=sm?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if(sa==null){
            Toast.makeText(this,"No hay sensor",Toast.LENGTH_LONG).show()
        }
        else{
            SEL = object : SensorEventListener{
                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                }
                override fun onSensorChanged(event: SensorEvent?) {
                    var x=event!!.values[0]
                    txtPosicion?.setText(x.toString())
                }

            }
        }
    }
    fun iniciar(){
        sm?.registerListener(SEL,sa,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onResume() {
        iniciar()
        super.onResume()
    }
    fun detener(){
        sm?.unregisterListener(SEL)
    }

    override fun onStop() {
        detener()
        super.onStop()
    }

}