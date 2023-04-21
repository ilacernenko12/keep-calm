package com.example.pokanetidei.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewUser(newUser:UsersEntity)
}