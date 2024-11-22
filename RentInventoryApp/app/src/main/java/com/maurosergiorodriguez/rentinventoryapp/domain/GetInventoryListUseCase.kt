package com.maurosergiorodriguez.rentinventoryapp.domain

import com.maurosergiorodriguez.rentinventoryapp.data.ItemRepository
import com.maurosergiorodriguez.rentinventoryapp.model.ItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInventoryListUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(): Flow<List<ItemModel>> = itemRepository.items
}