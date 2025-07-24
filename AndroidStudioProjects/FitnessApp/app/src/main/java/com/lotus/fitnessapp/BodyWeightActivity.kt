package com.lotus.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class BodyWeightActivity : AppCompatActivity() {

    private lateinit var btnBodyBack:    Button
    private lateinit var cardBWProg1:    CardView
    private lateinit var cardBWProg2:    CardView
    private lateinit var cardBWProg3:    CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_weight)

        btnBodyBack  = findViewById(R.id.btnBodyBack)
        cardBWProg1  = findViewById(R.id.cardBWProgram1)
        cardBWProg2  = findViewById(R.id.cardBWProgram2)
        cardBWProg3  = findViewById(R.id.cardBWProgram3)

        // Geri → AnaEkran
        btnBodyBack.setOnClickListener { finish() }

        // Programlara geçiş
        cardBWProg1.setOnClickListener {
            startActivity(Intent(this, BWProgram1Activity::class.java))
        }
        cardBWProg2.setOnClickListener {
            startActivity(Intent(this, BWProgram2Activity::class.java))
        }
        cardBWProg3.setOnClickListener {
            startActivity(Intent(this, BWProgram3Activity::class.java))
        }
    }
}