package com.example.assignment4_ulzhana.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment4_ulzhana.exm.User

@Dao
interface DaoUser {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>
}