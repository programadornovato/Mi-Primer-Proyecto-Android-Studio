package com.programadornovato.miprimerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ActivityRecibe : AppCompatActivity() {
    private var tvRecibe:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibe)

        tvRecibe=findViewById(R.id.tvRecibe)
        val dato=intent.getStringExtra("dato")
        tvRecibe?.text="El dato es $dato"
    }
    fun regresa(view:View){
        var intento=Intent(this,MainActivity::class.java)
        startActivity(intento)
    }
}