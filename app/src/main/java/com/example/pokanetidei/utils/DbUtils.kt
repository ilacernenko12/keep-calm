package com.example.pokanetidei.utils

import android.content.Context
import androidx.room.Room
import com.example.pokanetidei.database.RoomDb

class DbUtils {
    companion object {
        fun getRoom(context: Context): RoomDb {
            return Room.databaseBuilder(
                context,
                RoomDb::class.java,
                "user_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}