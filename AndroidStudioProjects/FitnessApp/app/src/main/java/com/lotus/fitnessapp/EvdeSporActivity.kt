package com.lotus.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class EvdeSporActivity : AppCompatActivity() {

    private lateinit var btnEvdeBack: Button
    private lateinit var cardDumbell: CardView
    private lateinit var cardBodyWeight: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evde_spor)

        btnEvdeBack     = findViewById(R.id.btnEvdeBack)
        cardDumbell     = findViewById(R.id.cardDumbell)
        cardBodyWeight  = findViewById(R.id.cardBodyWeight)

        // Geri = AnaEkran’a dön
        btnEvdeBack.setOnClickListener { finish() }

        // Dumbell Seti ekranına git
        cardDumbell.setOnClickListener {
            startActivity(Intent(this, DumbellActivity::class.java))
        }

        // Vücut Ağırlığı ekranına git
        cardBodyWeight.setOnClickListener {
            startActivity(Intent(this, BodyWeightActivity::class.java))
        }
    }
}