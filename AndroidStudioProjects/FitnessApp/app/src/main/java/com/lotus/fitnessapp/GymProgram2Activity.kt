package com.lotus.fitnessapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GymProgram2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_program2)

        findViewById<Button>(R.id.btnGymProg2Back).setOnClickListener {
            finish()
        }
    }
}