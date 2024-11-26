package com.example.farmer_room

import android.app.Application
import com.example.farmer_room.data.AppContainer
import com.example.farmer_room.data.AppDataContainer

class ItemApplication: Application() {
   lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}