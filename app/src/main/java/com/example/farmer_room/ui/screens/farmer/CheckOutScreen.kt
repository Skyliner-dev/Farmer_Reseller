package com.example.farmer_room.ui.screens.farmer

import android.media.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmer_room.ui.theme.Farmer_roomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen(
    onLogOut:() -> Unit
) {
    var bottomSheet by remember {
        mutableStateOf(false)
    }
    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Farmer Bob", fontSize = 28.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp))
            Surface(modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(10.dp),
                shadowElevation = 5.dp) {
                IconButton(onClick = {
                    bottomSheet = !bottomSheet
                }) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                }
            }
        }
        ElevatedCard(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("How many foods have been sold:", fontWeight = FontWeight.SemiBold)
                LinearProgressIndicator(
                    progress = { 0.5f }, modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp),
                    strokeCap = StrokeCap.Round,
                )
                Spacer(Modifier.padding(3.dp))
                Text("How many Vegetables have been sold:", fontWeight = FontWeight.SemiBold)
                LinearProgressIndicator(
                    progress = { 0.7f }, modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp),
                    strokeCap = StrokeCap.Round,
                )
                Spacer(Modifier.padding(3.dp))
                Text("How many fruits have been sold:", fontWeight = FontWeight.SemiBold)
                LinearProgressIndicator(
                    progress = { 0.3f }, modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp),
                    strokeCap = StrokeCap.Round,
                )
                Spacer(Modifier.padding(3.dp))
            }
        }
        ElevatedCard(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total Revenue:", fontWeight = FontWeight.SemiBold)
                    Text("\u20B9 69,690")
                }

            }
        }
        ElevatedCard(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Schemes Applied", fontWeight = FontWeight.SemiBold)
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
                Text("Pradhan Mantri Kisan Samman Nidhi (PM-KISAN)")
                Text("Pradhan Mantri Krishi Sinchayee Yojana (PMKSY)")
            }
        }
    }
    if (bottomSheet) {
        ModalBottomSheet(onDismissRequest = { bottomSheet = false }) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Bob is a great Farmer Fam!", fontSize = 24.sp)
                }
                Row(modifier= Modifier.fillMaxWidth().padding(16.dp)) {
                    Button(onClick = onLogOut) {
                        Text("Log Out")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CheckPreview() {
    Farmer_roomTheme(true) {
        Surface {
            CheckOutScreen({})
        }
    }
}