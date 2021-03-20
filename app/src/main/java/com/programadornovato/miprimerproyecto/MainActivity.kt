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
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Environment.getExternalStorageDirectory
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.theartofdev.edmodo.cropper.CropImage
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var cropActivityResultContract = object : ActivityResultContract<Any?, Uri?>(){
        override fun createIntent(context: Context, input: Any?): Intent {
            return CropImage.activity().setAspectRatio(16,9).getIntent(this@MainActivity)
        }
        override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
            return CropImage.getActivityResult(intent)?.uri
        }
    }
    private lateinit var cropActivityResultLauncher: ActivityResultLauncher<Any?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var imgCortada=findViewById<ImageView>(R.id.imgCortada)
        cropActivityResultLauncher = registerForActivityResult(cropActivityResultContract){
            it?.let {
                imgCortada.setImageURI(it)
            }
        }
    }
    fun clikBotonLlamaImagen(view:View){
        cropActivityResultLauncher.launch(null)
    }
}