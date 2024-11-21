package com.maurosergiorodriguez.rentinventoryapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.data.ItemDAO
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.data.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class InventoryDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDAO
}