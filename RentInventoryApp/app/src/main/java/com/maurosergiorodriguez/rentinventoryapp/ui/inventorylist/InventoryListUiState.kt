package com.maurosergiorodriguez.rentinventoryapp.ui.inventorylist

import com.maurosergiorodriguez.rentinventoryapp.model.ItemModel

sealed interface InventoryListUiState {
    data object Loading : InventoryListUiState
    data class Error(
        val throwable: Throwable
    ) : InventoryListUiState
    data class Success(
        val items: List<ItemModel>
    ) : InventoryListUiState
}