package com.lotus.fitnessapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GymProgram3Activity : AppCompatActivity (){
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_program3)

        findViewById<Button>(R.id.btnGymProg3Back).setOnClickListener {
            finish()
        }
    }
}