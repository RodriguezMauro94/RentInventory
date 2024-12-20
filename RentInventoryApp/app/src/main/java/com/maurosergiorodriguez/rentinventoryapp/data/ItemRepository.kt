package com.maurosergiorodriguez.rentinventoryapp.data

import com.maurosergiorodriguez.rentinventoryapp.model.ItemModel
import com.maurosergiorodriguez.rentinventoryapp.model.toData
import com.maurosergiorodriguez.rentinventoryapp.model.toItemStatus
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

    fun add(itemModel: ItemModel) {
        itemDao.add(itemModel.toData())
    }
}