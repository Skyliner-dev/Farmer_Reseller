package com.example.farmer_room

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.farmer_room.data.Item
import com.example.farmer_room.ui.screens.farmer.HomeViewModel
import com.example.farmer_room.ui.screens.farmer.ItemEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

        initializer {
            HomeViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}


fun CreationExtras.inventoryApplication(): ItemApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ItemApplication)
