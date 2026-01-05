package com.pavlov.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

interface EntryBuilder {
    fun build(
        scope: EntryProviderScope<NavKey>,
        coordinator: NavigationCoordinator,
        padding: PaddingValues
    )
}