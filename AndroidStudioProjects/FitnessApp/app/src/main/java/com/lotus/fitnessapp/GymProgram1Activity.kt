package com.lotus.fitnessapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GymProgram1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_program1)

        findViewById<Button>(R.id.btnGymProg1Back).setOnClickListener {
            finish()
        }
    }
}