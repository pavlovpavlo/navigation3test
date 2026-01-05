package com.pavlov.products.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pavlov.products.presentation.mvi.ProductDetailsIntent
import com.pavlov.products.presentation.mvi.ProductDetailsState

@Composable
fun ProductDetailsScreen(
    state: ProductDetailsState,
    onIntent: (ProductDetailsIntent) -> Unit,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = state.title,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Product ID: ${state.productId}",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = state.description,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { onIntent(ProductDetailsIntent.OnBackClicked) }) {
            Text(text = "Go Back")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { onIntent(ProductDetailsIntent.OnProfileClicked) }) {
            Text(text = "Go to Profile")
        }
    }
}

