package com.pavlov.products.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.ProductDetailsKey
import com.pavlov.products.presentation.ProductDetailsViewModel
import com.pavlov.products.presentation.navigation.ProductDetailsScreenEntry

fun EntryProviderScope<NavKey>.featureProductsBuilder(
    navigationCoordinator: NavigationCoordinator,
    productDetailsViewModelProvider: @Composable () -> ProductDetailsViewModel,
    paddingValues: PaddingValues
) {
    entry<ProductDetailsKey> {key ->
        ProductDetailsScreenEntry(navigationCoordinator, productDetailsViewModelProvider, paddingValues,
            productId = key.productId)
    }
}

