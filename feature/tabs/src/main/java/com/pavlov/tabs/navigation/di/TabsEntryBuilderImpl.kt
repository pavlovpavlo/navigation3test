package com.pavlov.tabs.navigation.di

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.EntryBuilder
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.tabs.presentation.home.presentation.HomeViewModel
import com.pavlov.tabs.navigation.featureTabsBuilder
import com.pavlov.tabs.presentation.products.presentation.ProductsViewModel
import com.pavlov.tabs.presentation.profile.presentation.ProfileViewModel
import javax.inject.Inject

class TabsEntryBuilderImpl @Inject constructor() : EntryBuilder {
    override fun build(
        scope: EntryProviderScope<NavKey>,
        coordinator: NavigationCoordinator,
        padding: PaddingValues
    ) {
        with(scope) {
            featureTabsBuilder(
                navigationCoordinator = coordinator,
                homeViewModelProvider = { hiltViewModel<HomeViewModel>() },
                productsViewModelProvider = { hiltViewModel<ProductsViewModel>() },
                profileViewModelProvider = { hiltViewModel<ProfileViewModel>() },
                paddingValues = padding
            )
        }
    }
}

