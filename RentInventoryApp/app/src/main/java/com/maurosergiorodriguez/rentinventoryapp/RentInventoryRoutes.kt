package com.maurosergiorodriguez.rentinventoryapp

sealed class RentInventoryRoutes(val route: String) {
    data object InventoryList : RentInventoryRoutes("inventoryList")
    data object AddItem : RentInventoryRoutes("addItem")
    data object EditItem : RentInventoryRoutes("editItem")
}
