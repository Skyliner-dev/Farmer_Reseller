package com.example.farmer_room.ui.screens.farmer

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer_room.R
import com.example.farmer_room.data.Item
import com.example.farmer_room.food.fm
import com.example.farmer_room.ui.theme.Farmer_roomTheme



@Composable
fun FoodScreen(
   items:List<Item>,
   onFabClick:() -> Unit
) {
   Scaffold(
      floatingActionButton = {
         FloatingActionButton(
            onClick = onFabClick
         ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
         }
      }
   ) {
      Column(
         modifier = Modifier
            .fillMaxSize()
            .padding(it),
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Row(
            modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
         ) {
            Text(
               "Your List", fontSize = 28.sp, fontWeight = FontWeight.Bold,
               modifier = Modifier.padding(horizontal = 16.dp)
            )
         }
         if (items.isEmpty()) {
            Box(modifier = Modifier
               .fillMaxSize()
               .wrapContentSize(align = Alignment.Center)) {
               Text("No Items, Pls add", modifier = Modifier.padding(bottom = 32.dp))
            }
         } else {
            Column(
               modifier = Modifier.padding(16.dp),
               verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
               items.forEach {
                  item ->
                  ItemCard(item)
               }
            }
         }
      }
   }
}
@Composable
fun ItemCard(
   item:Item
) {
   OutlinedCard(modifier = Modifier
      .fillMaxWidth()
   ) {
      Column(
         modifier = Modifier.padding(16.dp),
         verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
         Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(fm[item.name.lowercase()]?: R.drawable.apple),contentDescription = null,
               modifier = Modifier.size(60.dp))
            Text(item.name, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
         }
         Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Price: ")
            Text("\u20b9 " + item.price.toString())
         }
         Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Quantity: ")
            Text(item.quantity.toString())
         }
      }
   }
}

@Preview
@Composable
private fun ItemCardPreview() {
   Farmer_roomTheme {
      ItemCard(item = Item(1,"apple",20, 2))
   }
}
@Preview
@Composable
private fun FoodScreenPreview() {
   Farmer_roomTheme {
      FoodScreen(emptyList(),{})
   }
}