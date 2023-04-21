package com.example.pokanetidei.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UsersEntity::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase(){
    abstract val usersDao: UsersDao

    companion object {

        @Volatile
        private var INSTANCE: UsersDatabase? = null


        fun getInstance(context: Context): UsersDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UsersDatabase::class.java,
                        "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}