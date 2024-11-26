package com.example.farmer_room.ui.screens.retailer

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmer_room.data.Item
import com.example.farmer_room.ui.screens.farmer.HomeViewModel

enum class RetailerRoute(val icon:ImageVector) {
    RHome(Icons.Default.Home),
    Cart(Icons.Default.ShoppingCart)
}

@Composable
fun RetailerNavGraph(
    items:List<Item>,
    onButton:(Item) -> Unit,
    retailerUiState: RetailerUiState,
    onLogOutRetail:() -> Unit
) {
    var destination by remember {
        mutableStateOf(RetailerRoute.RHome)
    }
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                RetailerRoute.entries.forEach {
                    screen ->
                    NavigationBarItem(
                        selected = destination == screen,
                        onClick = {
                            destination = screen
                            navController.navigate(destination.name)
                        },
                        icon = {
                            Icon(imageVector = screen.icon, contentDescription = screen.name)
                        }
                    )

                }
            }
        }
    ) {
        innerPadding ->
        NavHost(navController = navController, startDestination = RetailerRoute.RHome.name, modifier = Modifier.padding(innerPadding)) {
            composable(route = RetailerRoute.RHome.name) {
                RetailerHomeScreen(items, onButton = onButton)
            }
            composable(route = RetailerRoute.Cart.name) {
                CartScreen(retailerUiState,onLogOutRetail)
            }
        }
    }
}