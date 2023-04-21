package com.example.pokanetidei

import android.app.Application
import androidx.room.Room
import com.example.pokanetidei.database.RoomDb
import com.example.pokanetidei.utils.DbUtils

class App : Application() {
    companion object {
        lateinit var room: RoomDb
    }

    override fun onCreate() {
        super.onCreate()

        room = DbUtils.getRoom(this)
    }

}