package com.example.farmer_room.ui.screens.retailer

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer_room.R
import com.example.farmer_room.food.fm
import com.example.farmer_room.ui.theme.Farmer_roomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    retailerUiState: RetailerUiState,
    onLogOutRetail:() -> Unit
) {
    var bottomSheetCart by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),) {
        Text("Your Order: ", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.padding(16.dp))
       retailerUiState.items.forEach {
           item ->
           CartCard(item)
           HorizontalDivider()
       }
        Spacer(Modifier.padding(16.dp))
        if (retailerUiState.items.isNotEmpty()) {
            Text(
                "Total: ₹${retailerUiState.items.sumOf { it.price }}",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(modifier = Modifier.fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)) {
            if (retailerUiState.items.isNotEmpty()) {
                ElevatedButton(
                    onClick = { bottomSheetCart = !bottomSheetCart },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Text("Pay For this")
                }
            }
            Spacer(Modifier.padding(8.dp))
            OutlinedButton(
                onClick = onLogOutRetail, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
            ) {
                Text("Log Out")
            }
        }

    }
    if (bottomSheetCart) {
        ModalBottomSheet(onDismissRequest = {bottomSheetCart = !bottomSheetCart}) {
            Box(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)) {
                 Text("You have No Balance!")
            }
        }
    }
}


@Composable
fun CartCard(
    item: CartItem
) {
    ListItem(
        leadingContent = {
            Image(painter = painterResource(fm[item.name]?:R.drawable.apple), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape))
        },
        headlineContent = {
            Text(item.name)
        },
        supportingContent = {
            Text("x ${item.quantity}")
        }
        , trailingContent = {
            Text("₹${item.price}")
        }
    )
//    ElevatedCard(modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(0.dp)
//    ) {
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 4.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
//            Image(painter = painterResource(R.drawable.apple), contentDescription = null,
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(CircleShape))
//            Text("Apple")
//            Text("x 2", modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentWidth(align = Alignment.End)
//                .padding(end = 16.dp))
//        }
//    }

}


//@Preview
//@Composable
//private fun CartScreenPreview() {
//    Farmer_roomTheme {
//        Surface {
////            CartScreen()
//        }
//    }
//}
@Preview
@Composable
private fun CartCardPreview() {
    Farmer_roomTheme {
        CartCard(CartItem("apple",2,30))
    }
}