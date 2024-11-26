package com.example.farmer_room.ui.screens.farmer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmer_room.data.Item
import com.example.farmer_room.ui.theme.Farmer_roomTheme

enum class FarmerDes(val icon: ImageVector) {
    Foods(Icons.Default.Home), CheckOut(Icons.Default.Person)
}

@Composable
fun FarmerHomeScreen(
    onLogOut: () -> Unit,
    onFabClick: () -> Unit,
    items: List<Item>
) {
    var selectedDestination by remember {
        mutableStateOf(FarmerDes.Foods)
    }
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                FarmerDes.entries.forEach {
                    screen ->
                    NavigationBarItem(
                        selected = selectedDestination == screen,
                        onClick = {
                            selectedDestination = screen
                            navController.navigate(selectedDestination.name)
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
        NavHost(navController = navController, startDestination = FarmerDes.Foods.name,
            modifier = Modifier.padding(innerPadding)) {
            composable(route = FarmerDes.Foods.name) {
                    FoodScreen(items = items,onFabClick)
            }
            composable(route = FarmerDes.CheckOut.name) {
                 CheckOutScreen(onLogOut = onLogOut)
            }
        }
    }
}


@Preview
@Composable
private fun FarmerHomeScreenPreview() {
    Farmer_roomTheme {
        FarmerHomeScreen({},{}, emptyList())
    }
}