package com.maurosergiorodriguez.rentinventoryapp.inventorylist.domain

import com.maurosergiorodriguez.rentinventoryapp.inventorylist.data.ItemRepository
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.model.ItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInventoryListUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(): Flow<List<ItemModel>> = itemRepository.items
}