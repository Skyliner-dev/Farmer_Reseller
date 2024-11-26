package com.example.farmer_room.ui.screens.retailer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.farmer_room.data.Item
import com.example.farmer_room.ui.theme.Farmer_roomTheme


@Composable
fun RetailerHomeScreen(
    items: List<Item>,
    onButton: (Item) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Buy Here: ", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        if (items.isEmpty()) {
            Text("No Items in Sale!", modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center))
        } else {
            items.forEach {
                item ->
                RetailerCard(item, onButton =onButton)
            }
        }
    }
}

@Composable
fun RetailerCard(
    item:Item,
    onButton:(Item) -> Unit
) {
   ElevatedCard(modifier = Modifier.fillMaxWidth()) {
       Row(modifier = Modifier.padding(16.dp),
           horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically
           ) {
           Text(item.name, fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
           Row(modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.End)) {
               Button(onClick = {onButton(item)}) {
                   Text("Buy")
               }
           }
       }
   }
}

@Preview
@Composable
private fun RetailerCardPreview() {
    Farmer_roomTheme {
        RetailerCard(item = Item(1,"apple",20, 2), onButton = {})
    }
}

