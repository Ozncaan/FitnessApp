package com.lotus.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnaEkran : AppCompatActivity() {

    private lateinit var btnBackToForm: Button
    private lateinit var cardEvde: CardView
    private lateinit var cardSalon: CardView
    private lateinit var tvUserName: TextView
    private lateinit var tvCalorieInfo: TextView
    private lateinit var userDao: UserDao

    private val activityLevelFactors = mapOf(
        "Az hareketli"   to 1.375,
        "Orta hareketli" to 1.55,
        "Çok hareketli"  to 1.725
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anaekran)

        // view binding
        btnBackToForm = findViewById(R.id.btnBackToForm)
        cardEvde      = findViewById(R.id.cardEvde)
        cardSalon     = findViewById(R.id.cardSalon)
        tvUserName    = findViewById(R.id.tvUserName)
        tvCalorieInfo = findViewById(R.id.tvCalorieInfo)

        // DAO
        userDao = AppDatabase.getDatabase(this).userDao()

        // fetch last user and update UI
        lifecycleScope.launch(Dispatchers.IO) {
            userDao.getLastUser()?.let { user ->
                val cals = calculateCalories(user)
                withContext(Dispatchers.Main) {
                    tvUserName.text    = "Kullanıcı: ${user.firstName}  ${user.lastName}"
                    tvCalorieInfo.text = "Günlük Kalori: $cals kcal"
                }
            }
        }

        // formu düzenle
        btnBackToForm.setOnClickListener {
            Intent(this, MainActivity::class.java)
                .putExtra("skipRedirect", true)
                .also {
                    startActivity(it)
                    finish()
                }
        }

        // kart tıklamaları
        cardEvde.setOnClickListener {
            startActivity(Intent(this, EvdeSporActivity::class.java))
        }
        cardSalon.setOnClickListener {
            startActivity(Intent(this, SporSalonuActivity::class.java))
        }
    }

    private fun calculateCalories(user: User): Int {
        val bmr = if (user.gender == "Erkek") {
            66.5 + 13.75 * user.weight + 5.003 * user.height - 6.775 * user.age
        } else {
            655.1 + 9.563 * user.weight + 1.850 * user.height - 4.676 * user.age
        }
        val factor = activityLevelFactors[user.activityLevel] ?: 1.0
        return (bmr * factor).toInt()
    }
}