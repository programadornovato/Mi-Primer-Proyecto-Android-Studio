package com.programadornovato.miprimerproyecto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class DrawView : View{
    var paint= Paint()
    var posX=0f
    var posY=0f
    constructor(context:Context?) : super(context){
        init()
    }
    private fun init() {
        paint.color= Color.RED
        paint.strokeWidth=10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f+posX,0f+posY,200f+posX,200f+posY,paint)
    }
}