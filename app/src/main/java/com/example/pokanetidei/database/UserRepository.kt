package com.example.pokanetidei.database

import com.example.pokanetidei.database.entity.UsersEntity

interface UserRepository {
    suspend fun insert(newUser: UsersEntity)
}