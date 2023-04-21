package com.example.pokanetidei.database

import com.example.pokanetidei.database.dao.UsersDao
import com.example.pokanetidei.database.entity.UsersEntity

class UserRepositoryImpl(private val usersDao: UsersDao): UserRepository {
    override suspend fun insert(newUser: UsersEntity) = usersDao.insertNewUser(newUser)
}