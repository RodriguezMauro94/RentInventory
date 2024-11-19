package com.maurosergiorodriguez.rentinventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.InventoryListScreen
import com.maurosergiorodriguez.rentinventoryapp.ui.theme.RentInventoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentInventoryAppTheme {
                InventoryListScreen()
            }
        }
    }
}
