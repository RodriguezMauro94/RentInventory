package com.maurosergiorodriguez.rentinventoryapp.domain

import com.maurosergiorodriguez.rentinventoryapp.data.ItemRepository
import com.maurosergiorodriguez.rentinventoryapp.model.ItemModel
import javax.inject.Inject

class AddItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(itemModel: ItemModel) = itemRepository.add(itemModel)
}