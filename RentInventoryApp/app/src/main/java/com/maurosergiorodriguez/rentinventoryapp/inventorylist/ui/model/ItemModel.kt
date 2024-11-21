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

fun ItemStatus.toString(): String {
    return when (this) {
        ItemStatus.Dirty -> "D"
        ItemStatus.InUse -> "I"
        ItemStatus.Stock -> "S"
        ItemStatus.Wasted -> "W"
    }
}

fun String.toItemStatus(): ItemStatus {
    return when(this) {
        "D" -> ItemStatus.Dirty
        "I" -> ItemStatus.InUse
        "S" -> ItemStatus.Stock
        "W" -> ItemStatus.Wasted
        else -> throw TypeCastException()
    }
}
