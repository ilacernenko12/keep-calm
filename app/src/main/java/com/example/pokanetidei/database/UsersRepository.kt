package com.example.pokanetidei.database

class UsersRepository(private val usersDao: UsersDao) {

    suspend fun insert(newUser: UsersEntity) = usersDao.insertNewUser(newUser)
}