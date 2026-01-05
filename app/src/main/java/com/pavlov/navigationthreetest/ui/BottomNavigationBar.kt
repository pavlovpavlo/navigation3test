package com.pavlov.navigationthreetest.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.HomeKey
import com.pavlov.navigation.ProductsKey
import com.pavlov.navigation.ProfileKey

enum class MainTab(
    val key: NavKey,
    val label: String,
    val icon: ImageVector
) {
    HOME(HomeKey, "Головна", Icons.Default.Home),
    PRODUCTS(ProductsKey, "Товари", Icons.Default.ShoppingCart),
    PROFILE(ProfileKey, "Профіль", Icons.Default.Person)
}

@Composable
fun BottomNavigationBar(
    currentTab: NavKey,
    onTabSelected: (NavKey) -> Unit
) {
    NavigationBar {
        MainTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = currentTab == tab.key,
                onClick = { onTabSelected(tab.key) },
                icon = { Icon(tab.icon, contentDescription = tab.label) },
                label = { Text(tab.label) }
            )
        }
    }
}