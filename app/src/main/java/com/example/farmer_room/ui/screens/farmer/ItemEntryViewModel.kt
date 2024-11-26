package com.example.farmer_room.ui.screens.farmer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.farmer_room.data.Item
import com.example.farmer_room.data.ItemsRepository

class ItemEntryViewModel(
    private val itemsRepository: ItemsRepository
): ViewModel() {

    var itemUiState by mutableStateOf(ItemDetails())
        private set

    fun updateName(name: String) {
        itemUiState = itemUiState.copy(name = name)
    }

    fun updatePrice(price: String) {
        itemUiState = itemUiState.copy(price = price)
    }

    fun updateQuantity(quantity: String) {
        itemUiState = itemUiState.copy(quantity = quantity)
    }

    suspend fun saveItem() {
        itemsRepository.insertItem(itemUiState.toItem())
    }

}

data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toIntOrNull() ?: 0,
    quantity = quantity.toIntOrNull() ?: 0
)
