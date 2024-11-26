package com.example.farmer_room.ui.screens.farmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.farmer_room.ui.theme.Farmer_roomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    itemEntryViewModel: ItemEntryViewModel,
    onNavigateUp: () -> Unit,
onSave: () -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf("")
    }
    var quantity by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Add Item")
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                value = name,
                onValueChange = {
                    name = it
                },
                label = {
                    Text("Enter Item Name")
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                value = price,
                onValueChange = {
                    price = it
                },
                label = {
                    Text("Enter Item Price")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                value = quantity,
                onValueChange = {
                    quantity = it
                },
                label = {
                    Text("Enter Item Quantity")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // Add a button to save the item
            Spacer(Modifier.padding(8.dp))

            ElevatedButton(
                onClick = onSave.also {
                    itemEntryViewModel.updateName(name)
                    itemEntryViewModel.updatePrice(price)
                    itemEntryViewModel.updateQuantity(quantity)
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Add Item")
            }


        }
    }
}

@Preview
@Composable
private fun ItemEditScreenPreview() {
    Farmer_roomTheme {
//        ItemEditScreen({},{})
    }
}