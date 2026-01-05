package com.pavlov.products.navigation.di

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.EntryBuilder
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.products.presentation.ProductDetailsViewModel
import com.pavlov.products.navigation.featureProductsBuilder
import javax.inject.Inject

class ProductsEntryBuilderImpl @Inject constructor() : EntryBuilder {
    override fun build(
        scope: EntryProviderScope<NavKey>,
        coordinator: NavigationCoordinator,
        padding: PaddingValues
    ) {
        with(scope) {
            featureProductsBuilder(
                navigationCoordinator = coordinator,
                productDetailsViewModelProvider = { hiltViewModel<ProductDetailsViewModel>() },
                paddingValues = padding
            )
        }
    }
}

