package com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.model

import java.util.UUID

data class ItemModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String? = "",
    val photo: String? = "",
    val price: Double? = 0.0,
    val brand: String,
    val status: ItemStatus = ItemStatus.Stock
)

sealed interface ItemStatus {
    data object Stock: ItemStatus
    data object InUse: ItemStatus
    data object Dirty: ItemStatus
    data object Wasted: ItemStatus
}
