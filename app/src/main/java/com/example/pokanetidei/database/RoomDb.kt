package com.example.pokanetidei.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokanetidei.database.dao.UsersDao
import com.example.pokanetidei.database.entity.UsersEntity

@Database(entities = [UsersEntity::class], version = 1, exportSchema = false)
abstract class RoomDb : RoomDatabase() {
    abstract val usersDao: UsersDao
}