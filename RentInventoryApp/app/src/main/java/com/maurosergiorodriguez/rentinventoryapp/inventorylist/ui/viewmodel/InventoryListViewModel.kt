package com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.domain.GetInventoryListUseCase
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.InventoryListUiState
import com.maurosergiorodriguez.rentinventoryapp.inventorylist.ui.InventoryListUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InventoryListViewModel @Inject constructor(
    getInventoryListUseCase: GetInventoryListUseCase
): ViewModel() {
    val uiInventoryList: StateFlow<InventoryListUiState> = getInventoryListUseCase()
        .map(::Success)
        .catch {
            Error(it)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            Loading
        )
}