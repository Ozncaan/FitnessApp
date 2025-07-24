package com.lotus.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SporSalonuActivity : AppCompatActivity() {

    private lateinit var btnSalonBack: Button
    private lateinit var card1: CardView
    private lateinit var card2: CardView
    private lateinit var card3: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spor_salonu)

        btnSalonBack = findViewById(R.id.btnSalonBack)
        card1        = findViewById(R.id.cardGymProg1)
        card2        = findViewById(R.id.cardGymProg2)
        card3        = findViewById(R.id.cardGymProg3)

        // Geri → AnaEkran
        btnSalonBack.setOnClickListener { finish() }

        // Program aktivitelerine geçiş
        card1.setOnClickListener {
            startActivity(Intent(this, GymProgram1Activity::class.java))
        }
        card2.setOnClickListener {
            startActivity(Intent(this, GymProgram2Activity::class.java))
        }
        card3.setOnClickListener {
            startActivity(Intent(this, GymProgram3Activity::class.java))
        }
    }
}