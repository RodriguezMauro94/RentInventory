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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(navController: NavController) {
    var title by remember {
        mutableStateOf("")
    }
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
            modifier = Modifier.padding( horizontal =  18.dp)
        ) {
            ItemTextView("Title") {
                title = it
            }
            ItemTextView("Description", optional = true) {
                title = it
            }
            ItemTextView("Brand") {
                title = it
            }
            ItemTextView(
                text = "Price",
                optional = true,
                keyboardType = KeyboardType.Number
            ) {
                title = it
            }
            StatusCombo()

            Spacer(modifier = Modifier.size(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                }
            ) {
                Text("Confirm")
            }
        }
    }
}

@Composable
fun StatusCombo(default: String = "Stock") {
    val statusList = listOf("Stock", "In Use", "Dirty", "Broken/Missing")
    var selectedTitle by rememberSaveable {
        mutableStateOf(default)
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedTitle,
            onValueChange = {
                selectedTitle = it
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
            statusList.forEach {
                DropdownMenuItem(text = {
                    Text(it)
                }, onClick = {
                    selectedTitle = it
                    expanded = false
                })
            }
        }
    }
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
private fun ItemTextView(text: String, optional: Boolean = false, keyboardType: KeyboardType = KeyboardType.Text, onValueChanged: (String) -> Unit) {
    var myTask by remember { mutableStateOf("") }
    TextField(
        value = myTask,
        onValueChange = {
            myTask = it
        },
        placeholder = {
            if (optional) {
                Text("(Optional) $text")
            } else {
                Text(text)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
    Spacer(modifier = Modifier.size(12.dp))
}