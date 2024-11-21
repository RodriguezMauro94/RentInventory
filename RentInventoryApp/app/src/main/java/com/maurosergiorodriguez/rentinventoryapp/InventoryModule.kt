package com.maurosergiorodriguez.rentinventoryapp

import android.content.Context
import androidx.room.Room
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.data.ItemDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InventoryModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context): InventoryDatabase {
        return Room.databaseBuilder(
            appContext,
            InventoryDatabase::class.java,
            "InventoryDatabase"
        ).build()
    }

    @Provides
    fun providesItemDao(inventoryDatabase: InventoryDatabase): ItemDAO {
        return inventoryDatabase.itemDao()
    }
}