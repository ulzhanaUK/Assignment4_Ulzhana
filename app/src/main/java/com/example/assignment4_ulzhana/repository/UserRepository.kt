package com.example.assignment4_ulzhana.repository

import androidx.lifecycle.LiveData
import com.example.assignment4_ulzhana.dao.DaoUser
import com.example.assignment4_ulzhana.exm.User

class UserRepository(private val userDao: DaoUser) {

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun update(user: User) {
        userDao.update(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }
}
