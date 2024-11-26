package com.example.farmer_room.data

import android.content.Context

interface AppContainer {
    val itemsRepository: ItemsRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    override val itemsRepository: ItemsRepository by lazy {
        OfflineRepository(ItemDatabase.getDatabase(context).itemDao())
    }

}