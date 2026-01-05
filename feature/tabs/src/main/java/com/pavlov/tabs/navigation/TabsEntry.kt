package com.pavlov.tabs.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.HomeKey
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.ProductsKey
import com.pavlov.navigation.ProfileKey
import com.pavlov.tabs.presentation.home.presentation.HomeViewModel
import com.pavlov.tabs.presentation.home.presentation.navigation.HomeScreenEntry
import com.pavlov.tabs.presentation.products.presentation.ProductsViewModel
import com.pavlov.tabs.presentation.products.presentation.navigation.ProductsScreenEntry
import com.pavlov.tabs.presentation.profile.presentation.ProfileViewModel
import com.pavlov.tabs.presentation.profile.presentation.navigation.ProfileScreenEntry

fun EntryProviderScope<NavKey>.featureTabsBuilder(
    navigationCoordinator: NavigationCoordinator,
    homeViewModelProvider: @Composable () -> HomeViewModel,
    productsViewModelProvider: @Composable () -> ProductsViewModel,
    profileViewModelProvider: @Composable () -> ProfileViewModel,
    paddingValues: PaddingValues
) {
    entry<HomeKey> {
        HomeScreenEntry(navigationCoordinator, homeViewModelProvider, paddingValues)
    }
    entry<ProductsKey> {
        ProductsScreenEntry(navigationCoordinator, productsViewModelProvider, paddingValues)
    }
    entry<ProfileKey> {
        ProfileScreenEntry(navigationCoordinator, profileViewModelProvider, paddingValues)
    }
}

