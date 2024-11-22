package com.maurosergiorodriguez.rentinventoryapp.ui.additem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun EditItemScreen() {
    Column(
        modifier = Modifier.padding(18.dp)
    ) {
        ItemTextView()
        ItemTextView()
        ItemTextView()
        ItemTextView()
    }

}

@Composable
private fun ItemTextView() {
    var myTask by remember { mutableStateOf("") }
    TextField(
        value = myTask,
        onValueChange = {
            myTask = it
        },
        placeholder = {
            Text("")
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1
    )
    Spacer(modifier = Modifier.size(12.dp))
}