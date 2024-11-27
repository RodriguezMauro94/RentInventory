package com.maurosergiorodriguez.rentinventoryapp.ui.additem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.maurosergiorodriguez.rentinventoryapp.model.ItemStatus
import com.maurosergiorodriguez.rentinventoryapp.ui.additem.viewmodel.AddItemViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(addItemViewModel: AddItemViewModel, navController: NavController) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var price by remember { mutableDoubleStateOf(0.0) }
    var status by remember { mutableStateOf(ItemStatus.Stock) }
    Column {
        TopAppBar(
            title = {
                Text("Add item")
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                }
            }
        )
        Column(
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
            ItemTextView(value = title, placeHolder = "Title") {
                title = it
            }
            ItemTextView(value = description, placeHolder = "Description", optional = true) {
                description = it
            }
            ItemTextView(value = brand, placeHolder = "Brand") {
                brand = it
            }
            ItemTextView(value = price.toString(),
                placeHolder = "Price",
                optional = true,
                keyboardType = KeyboardType.Number
            ) {
                price = it.toDouble()
            }
            StatusCombo(status) {
                status = it
            }

            Spacer(modifier = Modifier.size(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    addItemViewModel.add(
                        title,
                        description,
                        brand,
                        price,
                        status
                    )
                }
            ) {
                Text("Confirm")
            }
        }
    }
}

@Composable
fun StatusCombo(initialValue: ItemStatus, onValueChanged: (ItemStatus) -> Unit) {
    val statusList = ItemStatus.entries
    var selectedTitle by rememberSaveable {
        mutableStateOf(initialValue)
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedTitle.value,
            onValueChange = {
                selectedTitle = ItemStatus.valueOf(it)
                onValueChanged(selectedTitle)
            },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            statusList.forEach { status ->
                DropdownMenuItem(text = {
                    Text(status.value)
                }, onClick = {
                    selectedTitle = status
                    expanded = false
                })
            }
        }
    }
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
private fun ItemTextView(
    value: String = "",
    placeHolder: String,
    optional: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        placeholder = {
            if (optional) {
                Text("(Optional) $placeHolder")
            } else {
                Text(placeHolder)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
    Spacer(modifier = Modifier.size(12.dp))
}