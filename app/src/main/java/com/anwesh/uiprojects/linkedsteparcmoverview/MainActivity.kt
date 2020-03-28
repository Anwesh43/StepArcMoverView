package com.anwesh.uiprojects.linkedsteparcmoverview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.steparcmoverview.StepArcMoverView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StepArcMoverView.create(this)
    }
}

