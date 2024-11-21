package com.maurosergiorodriguez.rentinventoryapp.inventorylist.data

import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.model.ItemModel
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.model.toItemStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepository @Inject constructor(
    private val itemDao: ItemDAO
) {
    val items: Flow<List<ItemModel>> = itemDao.getItems().map { item ->
        item.map {
            ItemModel(
                id = it.id,
                title = it.title,
                description = it.description,
                photo = it.photo,
                price = it.price,
                brand = it.brand,
                status = it.status.toItemStatus(),
            )
        }
    }
}