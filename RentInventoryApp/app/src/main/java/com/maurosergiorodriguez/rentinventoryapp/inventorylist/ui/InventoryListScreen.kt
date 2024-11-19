package com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maurosergiorodriguez.rentinventoryapp.R
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.model.ItemModel
import kotlinx.coroutines.CoroutineScope
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
                    DrawerItem(stringResource(R.string.state_in_use)) {
                        //TODO load In Use Items
                        closeDrawer(coroutineScope, drawerState)
                    }

                    DrawerItem(stringResource(R.string.state_stock)) {
                        //TODO load Stock Items
                        closeDrawer(coroutineScope, drawerState)
                    }

                    DrawerItem(stringResource(R.string.state_wasted)) {
                        //TODO load Wasted Items
                        closeDrawer(coroutineScope, drawerState)
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(R.string.app_name))
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = stringResource(R.string.menu))
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    //TODO goto add item screen
                }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(R.string.add_item))
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

private fun closeDrawer(
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    coroutineScope.launch {
        drawerState.close()
    }
}
