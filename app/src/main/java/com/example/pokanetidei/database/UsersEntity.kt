package com.example.pokanetidei.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_database")
data class UsersEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "password")
    var password: String
)