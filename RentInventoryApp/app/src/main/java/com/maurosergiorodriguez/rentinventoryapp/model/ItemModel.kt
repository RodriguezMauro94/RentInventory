package com.maurosergiorodriguez.rentinventoryapp.model

import com.maurosergiorodriguez.rentinventoryapp.data.ItemEntity
import com.maurosergiorodriguez.rentinventoryapp.model.ItemStatus.Dirty
import com.maurosergiorodriguez.rentinventoryapp.model.ItemStatus.InUse
import com.maurosergiorodriguez.rentinventoryapp.model.ItemStatus.Stock
import com.maurosergiorodriguez.rentinventoryapp.model.ItemStatus.Wasted
import java.util.UUID

data class ItemModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String? = "",
    val photo: String? = "",
    val price: Double? = 0.0,
    val brand: String,
    val status: ItemStatus = Stock
)

enum class ItemStatus(
    val value: String,
    val key: Char
) {
    Stock("Stock", 'S'),
    InUse("In Use", 'I'),
    Dirty("Dirty", 'D'),
    Wasted("Wasted", 'W'),
}

fun Char.toItemStatus(): ItemStatus {
    return when(this) {
        'S' -> Stock
        'I' -> InUse
        'D' -> Dirty
        'W' -> Wasted
        else -> throw TypeCastException()
    }
}

fun ItemModel.toData(): ItemEntity {
    return ItemEntity(
        id = id,
        title = title,
        description = description,
        brand = brand,
        status = status.key
    )
}