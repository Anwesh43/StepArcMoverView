package com.anwesh.uiprojects.steparcmoverview

/**
 * Created by anweshmishra on 28/03/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Color
import android.graphics.Canvas

val nodes : Int = 5
val parts : Int = 3
val scGap : Float = 0.02f
val delay : Long = 20
val deg : Float = 360f
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawStepArcMover(scale : Float, w : Float, size : Float, paint : Paint) {
    val degPart : Float = 360f / parts
    val scDiv : Double = 1.0 / parts
    val k : Int = Math.floor(scale.sinify() / scDiv).toInt()
    val sf : Float = scale.sinify().divideScale(k, parts)
    val sf1 : Float = sf.divideScale(0, 2)
    val sf2 : Float = sf.divideScale(1, 2)
    val gap : Float = (w - 2 * size) / parts
    save()
    translate(size + gap * k + gap * sf1, 0f)
    drawArc(RectF(-size, -size, size, size), 0f, degPart * k + degPart * sf2, true, paint)
    restore()
}

fun Canvas.drawSAMNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    save()
    translate(0f, gap * (i + 1))
    drawStepArcMover(scale, w, size, paint)
    restore()
}

class StepArcMoverView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
