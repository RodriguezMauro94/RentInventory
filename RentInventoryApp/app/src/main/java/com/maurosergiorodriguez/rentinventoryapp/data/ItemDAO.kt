package com.maurosergiorodriguez.rentinventoryapp.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO {
    @Query("SELECT * FROM ItemEntity")
    fun getItems(): Flow<List<ItemEntity>>
}