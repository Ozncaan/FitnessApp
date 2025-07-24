package com.lotus.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val PREFS_NAME    = "app_prefs"
    private val KEY_FORM_DONE = "form_completed"
    private val EXTRA_SKIP    = "skipRedirect"

    private lateinit var etFirstName: EditText
    private lateinit var etLastName:  EditText
    private lateinit var rgGender:    RadioGroup
    private lateinit var etAge:       EditText
    private lateinit var etHeight:    EditText
    private lateinit var etWeight:    EditText
    private lateinit var spinnerActivityLevel: Spinner
    private lateinit var btnCalculate:        Button

    private lateinit var userDao: UserDao

    // Aktivite seviyesi çarpanları
    private val activityLevelFactors = mapOf(
        "Az hareketli"   to 1.375,
        "Orta hareketli" to 1.55,
        "Çok hareketli"  to 1.725
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs         = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val skipRedirect  = intent.getBooleanExtra(EXTRA_SKIP, false)

        // Eğer form daha önce doldurulmuş ve geri düzenleme istenmiyorsa doğrudan AnaEkran'a geç
        if (!skipRedirect && prefs.getBoolean(KEY_FORM_DONE, false)) {
            startActivity(Intent(this, AnaEkran::class.java))
            finish()
            return
        }

        // Aksi halde formu göster
        setContentView(R.layout.activity_main)

        // View’ları bağla
        etFirstName          = findViewById(R.id.etFirstName)
        etLastName           = findViewById(R.id.etLastName)
        rgGender             = findViewById(R.id.rgGender)
        etAge                = findViewById(R.id.etAge)
        etHeight             = findViewById(R.id.etHeight)
        etWeight             = findViewById(R.id.etWeight)
        spinnerActivityLevel = findViewById(R.id.spinnerActivityLevel)
        btnCalculate         = findViewById(R.id.btnCalculate)

        // Spinner adapter
        spinnerActivityLevel.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            activityLevelFactors.keys.toList()
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Room DAO
        userDao = AppDatabase.getDatabase(this).userDao()

        btnCalculate.setOnClickListener {
            // Girdileri al
            val firstName = etFirstName.text.toString().trim()
            val lastName  = etLastName.text.toString().trim()
            val gender    = when (rgGender.checkedRadioButtonId) {
                R.id.rbMale   -> "Erkek"
                R.id.rbFemale -> "Kadın"
                else          -> ""
            }
            val age      = etAge.text.toString().toIntOrNull()
            val height   = etHeight.text.toString().toDoubleOrNull()
            val weight   = etWeight.text.toString().toDoubleOrNull()
            val activity = spinnerActivityLevel.selectedItem as String

            // Validasyon
            if (firstName.isEmpty() ||
                lastName.isEmpty()  ||
                gender.isEmpty()    ||
                age == null         ||
                height == null      ||
                weight == null
            ) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Veriyi kaydet
            val user = User(
                firstName     = firstName,
                lastName      = lastName,
                gender        = gender,
                age           = age,
                height        = height,
                weight        = weight,
                activityLevel = activity
            )
            lifecycleScope.launch(Dispatchers.IO) {
                userDao.insert(user)
            }

            // Form doldurma bayrağını sakla
            prefs.edit().putBoolean(KEY_FORM_DONE, true).apply()

            // Ana ekrana geç
            startActivity(Intent(this, AnaEkran::class.java))
            finish()
        }
    }
}