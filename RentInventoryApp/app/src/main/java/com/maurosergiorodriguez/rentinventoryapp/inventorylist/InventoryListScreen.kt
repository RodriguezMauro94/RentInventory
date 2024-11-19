package com.maurosergiorodriguez.rentinventoryapp.inventorylist

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.ItemModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryListScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val items = listOf(
        ItemModel(title = "Item 1", brand = "ACME"),
        ItemModel(title = "Item 2", brand = "ACME"),
        ItemModel(title = "Item 3", brand = "ACME"),
        ItemModel(title = "Item 4", brand = "ACME"),
        ItemModel(title = "Item 5", brand = "ACME"),
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    TextButton(onClick = {
                        //TODO load In Use Items
                    }) {
                        Text(
                            "In Use",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    TextButton(onClick = {
                        //TODO load Stock Items
                    }) {
                        Text(
                            "Stock",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    TextButton(onClick = {
                        //TODO load Wasted Items
                    }) {
                        Text(
                            "Wasted Items",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Rent Inventory")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    //TODO goto add item screen
                }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Item")
                }
            }
        ) { padding ->
            LazyColumn {
                items(items, key = { it.id }) { item ->
                    ItemCard(item)
                }
            }
        }
    }
}

@Composable
fun ItemCard(item: ItemModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures(onLongPress = {
                    //TODO show edit/remove dialog
                })
            }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = item.title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = item.brand, fontSize = 12.sp)
        }
    }
}
