package com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui

import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.model.ItemModel

sealed interface InventoryListUiState {
    data object Loading : InventoryListUiState
    data class Error(
        val throwable: Throwable
    ) : InventoryListUiState
    data class Success(
        val items: List<ItemModel>
    ) : InventoryListUiState
}