package com.example.farmer_room.ui.screens.retailer


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RetailerViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(RetailerUiState())
    val uiState: StateFlow<RetailerUiState> = _uiState.asStateFlow()

    fun addItem(item: CartItem) {
        _uiState.value = _uiState.value.copy(items = _uiState.value.items + item)
    }




}

data class RetailerUiState(
    val items: List<CartItem> = emptyList()
)

data class CartItem (
    val name:String,
    val quantity:Int,
    val price:Int
)