package com.maurosergiorodriguez.rentinventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maurosergiorodriguez.rentinventoryapp.ui.additem.AddItemScreen
import com.maurosergiorodriguez.rentinventoryapp.ui.additem.viewmodel.AddItemViewModel
import com.maurosergiorodriguez.rentinventoryapp.ui.inventorylist.InventoryListScreen
import com.maurosergiorodriguez.rentinventoryapp.ui.inventorylist.viewmodel.InventoryListViewModel
import com.maurosergiorodriguez.rentinventoryapp.ui.theme.RentInventoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val inventoryListViewModel: InventoryListViewModel by viewModels()
    private val addItemViewModel: AddItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentInventoryAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = RentInventoryRoutes.InventoryList.route
                ) {
                    composable(route = RentInventoryRoutes.InventoryList.route) {
                        InventoryListScreen(inventoryListViewModel, navController)
                    }
                    composable(route = RentInventoryRoutes.AddItem.route) {
                        AddItemScreen(addItemViewModel, navController)
                    }
                }
            }
        }
    }
}
