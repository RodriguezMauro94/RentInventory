package com.maurosergiorodriguez.rentinventoryapp.ui.inventorylist

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maurosergiorodriguez.rentinventoryapp.model.ItemModel

@Composable
fun ItemCard(item: ItemModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures(onLongPress = {
                    //TODO show edit/remove dialog
                })
            }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = item.title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = item.brand, fontSize = 12.sp)
        }
    }
}

@Composable
fun DrawerItem(name: String, onDrawerItemClicked: () -> Unit) {
    TextButton(onClick = {
        onDrawerItemClicked()
    }) {
        Text(
            text = name,
            modifier = Modifier.padding(8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
