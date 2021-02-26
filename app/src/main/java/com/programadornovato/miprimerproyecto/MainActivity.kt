package com.programadornovato.miprimerproyecto

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clicBoton(view: View){
        when(view.id){
            R.id.btn0 -> Toast.makeText(this,"Diste click en 0",Toast.LENGTH_LONG).show()
            R.id.btn1 -> Toast.makeText(this,"Diste click en 1",Toast.LENGTH_LONG).show()
            R.id.btn2 -> Toast.makeText(this,"Diste click en 2",Toast.LENGTH_LONG).show()
            R.id.btn3 -> Toast.makeText(this,"Diste click en 3",Toast.LENGTH_LONG).show()
            R.id.btn4 -> Toast.makeText(this,"Diste click en 4",Toast.LENGTH_LONG).show()
            R.id.btn5 -> Toast.makeText(this,"Diste click en 5",Toast.LENGTH_LONG).show()
            R.id.btn6 -> Toast.makeText(this,"Diste click en 6",Toast.LENGTH_LONG).show()
            R.id.btn7 -> Toast.makeText(this,"Diste click en 7",Toast.LENGTH_LONG).show()
            R.id.btn8 -> Toast.makeText(this,"Diste click en 8",Toast.LENGTH_LONG).show()
            R.id.btn9 -> Toast.makeText(this,"Diste click en 9",Toast.LENGTH_LONG).show()
            R.id.btn10 -> Toast.makeText(this,"Diste click en 10",Toast.LENGTH_LONG).show()
        }
    }
}