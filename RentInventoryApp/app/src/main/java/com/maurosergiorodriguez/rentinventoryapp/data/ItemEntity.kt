package com.maurosergiorodriguez.rentinventoryapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String? = "",
    val photo: String? = "",
    val price: Double? = 0.0,
    val brand: String,
    val status: Char
)
