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
    var x1=FloatArray(4)
    var y1=FloatArray(4)
    var x2=FloatArray(4)
    var y2=FloatArray(4)
    var giro=0.0
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in 0 until 4){
            x1[i]=(Math.cos(giro)*200+300).toFloat()
            y1[i]=(Math.sin(giro)*200+300).toFloat()
            x2[i]=(Math.cos(giro+(Math.PI/2))*200+300).toFloat()
            y2[i]=(Math.sin(giro+(Math.PI/2))*200+300).toFloat()
            canvas?.drawLine(x1[i],y1[i],x2[i],y2[i],paint  )
            giro=giro+Math.PI/2
        }
        giro=giro+0.1
    }
}