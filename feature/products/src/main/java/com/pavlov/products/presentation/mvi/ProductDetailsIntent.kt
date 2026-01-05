package com.pavlov.products.presentation.mvi

sealed interface ProductDetailsIntent {
    data object OnBackClicked : ProductDetailsIntent
    data object OnProfileClicked : ProductDetailsIntent
}

