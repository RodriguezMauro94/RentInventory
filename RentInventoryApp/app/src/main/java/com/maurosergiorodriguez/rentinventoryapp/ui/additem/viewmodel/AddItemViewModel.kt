package com.maurosergiorodriguez.rentinventoryapp.ui.additem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maurosergiorodriguez.rentinventoryapp.domain.AddItemUseCase
import com.maurosergiorodriguez.rentinventoryapp.model.ItemModel
import com.maurosergiorodriguez.rentinventoryapp.model.ItemStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    val addItemUseCase: AddItemUseCase
): ViewModel() {
    //FIXME add some strategy to callback

    fun add(
        title: String,
        description: String?,
        brand: String,
        price: Double?,
        status: ItemStatus
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            addItemUseCase(
                ItemModel(
                    title = title,
                    description = description,
                    brand = brand,
                    price = price,
                    status = status
                )
            )
        }
    }
}