package com.lotus.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DumbellActivity : AppCompatActivity() {

    private lateinit var btnDumbellBack: Button
    private lateinit var card1: CardView
    private lateinit var card2: CardView
    private lateinit var card3: CardView
    private lateinit var card4: CardView
    private lateinit var card5: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dumbell)

        btnDumbellBack = findViewById(R.id.btnDumbellBack)
        card1          = findViewById(R.id.cardProgram1)
        card2          = findViewById(R.id.cardProgram2)
        card3          = findViewById(R.id.cardProgram3)
        card4          = findViewById(R.id.cardProgram4)
        card5          = findViewById(R.id.cardProgram5)

        btnDumbellBack.setOnClickListener { finish() }

        card1.setOnClickListener {
            startActivity(Intent(this, Program1Activity::class.java))
        }
        card2.setOnClickListener {
            startActivity(Intent(this, Program2Activity::class.java))
        }
        card3.setOnClickListener {
            startActivity(Intent(this, Program3Activity::class.java))
        }
        card4.setOnClickListener {
            startActivity(Intent(this, Program4Activity::class.java))
        }
        card5.setOnClickListener {
            startActivity(Intent(this, Program5Activity::class.java))
        }
    }
}