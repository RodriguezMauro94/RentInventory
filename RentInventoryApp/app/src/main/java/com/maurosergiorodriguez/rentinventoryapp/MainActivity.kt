package com.maurosergiorodriguez.rentinventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.InventoryListScreen
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.viewmodel.InventoryListViewModel
import com.maurosergiorodriguez.rentinventoryapp.ui.theme.RentInventoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val inventoryListViewModel: InventoryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentInventoryAppTheme {
                InventoryListScreen(inventoryListViewModel)
            }
        }
    }
}
