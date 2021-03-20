package com.programadornovato.miprimerproyecto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class DrawView : View{
    var paint= Paint()
    constructor(context:Context?) : super(context){
        init()
    }
    private fun init() {
        paint.color= Color.RED
        paint.strokeWidth=10f
    }
    var x1a=FloatArray(4)
    var y1a=FloatArray(4)
    var x2a=FloatArray(4)
    var y2a=FloatArray(4)

    var x1b=FloatArray(4)
    var y1b=FloatArray(4)
    var x2b=FloatArray(4)
    var y2b=FloatArray(4)

    var tamaño=200
    var posicion=100
    var giro=0.5
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in 0 until 4){
            x1a[i]=(Math.cos(giro)*tamaño+posicion).toFloat()
            y1a[i]=(Math.sin(giro)*tamaño+posicion).toFloat()
            x2a[i]=(Math.cos(giro+(Math.PI/2))*tamaño+posicion).toFloat()
            y2a[i]=(Math.sin(giro+(Math.PI/2))*tamaño+posicion).toFloat()
            canvas?.drawLine(x1a[i],y1a[i],x2a[i],y2a[i],paint  )

            x1b[i]=(Math.cos(giro)*tamaño+posicion+(tamaño/2)).toFloat()
            y1b[i]=(Math.sin(giro)*tamaño+posicion+(tamaño/2)).toFloat()
            x2b[i]=(Math.cos(giro+(Math.PI/2))*tamaño+posicion+(tamaño/2)).toFloat()
            y2b[i]=(Math.sin(giro+(Math.PI/2))*tamaño+posicion+(tamaño/2)).toFloat()
            canvas?.drawLine(x1b[i],y1b[i],x2b[i],y2b[i],paint  )

            canvas?.drawLine(x1a[i],y1a[i],x1b[i],y1b[i],paint  )
            giro=giro+Math.PI/2
        }
        giro=giro+0.1
        posicion=posicion+10
    }
}