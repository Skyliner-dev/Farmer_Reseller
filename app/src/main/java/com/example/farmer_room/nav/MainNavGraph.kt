package com.example.farmer_room.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmer_room.AppViewModelProvider
import com.example.farmer_room.ui.screens.farmer.FarmerHomeScreen
import com.example.farmer_room.ui.screens.farmer.HomeViewModel
import com.example.farmer_room.ui.screens.farmer.ItemEditScreen
import com.example.farmer_room.ui.screens.farmer.ItemEntryViewModel
import com.example.farmer_room.ui.screens.login.LoginScreen
import com.example.farmer_room.ui.screens.retailer.CartItem
import com.example.farmer_room.ui.screens.retailer.RetailerNavGraph
import com.example.farmer_room.ui.screens.retailer.RetailerViewModel
import kotlinx.coroutines.launch

enum class Routes {
    Login,
    FarmerHome,
    ItemAdd,
    RetailerHome
}

@Composable
fun MainNavGraph(
     homeViewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
     itemEntryViewModel: ItemEntryViewModel = viewModel(factory = AppViewModelProvider.Factory),
     retailerViewModel: RetailerViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val homeUiState by homeViewModel.homeUiState.collectAsState()
    val retailUiState by retailerViewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Routes.Login.name) {
        composable(route = Routes.Login.name) {
            LoginScreen(
                onFarmerClick = {navController.navigate(Routes.FarmerHome.name)},
                onRetailerClick = {navController.navigate(Routes.RetailerHome.name)}
            )
        }
        composable(route = Routes.FarmerHome.name) {
            FarmerHomeScreen(onLogOut = {navController.popBackStack(route = Routes.Login.name, inclusive = false, saveState = true)},
                onFabClick = {navController.navigate(Routes.ItemAdd.name)}, items = homeUiState.itemList)
        }
        composable(route = Routes.ItemAdd.name) {
            ItemEditScreen(itemEntryViewModel = itemEntryViewModel, onNavigateUp = {navController.popBackStack()},
                onSave = {
                    coroutineScope.launch {
                        itemEntryViewModel.saveItem()
                        navController.popBackStack()
                    }
                }
                )
        }
        composable(route = Routes.RetailerHome.name) {
            RetailerNavGraph(homeUiState.itemList,
                onButton = {retailerViewModel.addItem(CartItem(it.name, it.quantity, it.price))},
                retailUiState, onLogOutRetail = {navController.popBackStack(route = Routes.Login.name, inclusive = false, saveState = true)})
        }
    }
}