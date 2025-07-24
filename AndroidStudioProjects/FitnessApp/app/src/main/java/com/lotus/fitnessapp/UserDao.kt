package com.lotus.fitnessapp
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    // Kullanıcı bilgisini getiren örnek sorgu
    @Query("SELECT * FROM user_table ORDER BY id DESC LIMIT 1")
    suspend fun getLastUser(): User?
}