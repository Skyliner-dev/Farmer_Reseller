package com.example.farmer_room.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer_room.ui.theme.Farmer_roomTheme

@Composable
fun LoginScreen(
    onFarmerClick: () -> Unit,
    onRetailerClick: () -> Unit

) {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text("Crop2Cart", color = Color(90, 180, 50),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold)
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart",
                        tint = Color(90,220,50), modifier = Modifier.size(75.dp))
                }
                Spacer(modifier = Modifier.padding(24.dp))
                ElevatedButton(
                    onClick = onFarmerClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Farmer")
                }
                ElevatedButton(
                    onClick = onRetailerClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Retailer")
                }
            }
        }

}


@Preview
@Composable
private fun LoginScreenPreview() {
    Farmer_roomTheme() {
        LoginScreen({},{})
    }
}