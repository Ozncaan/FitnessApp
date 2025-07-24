package com.lotus.fitnessapp
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val age: Int,
    val height: Double,   // cm cinsinden
    val weight: Double,   // kg cinsinden
    val activityLevel: String
)