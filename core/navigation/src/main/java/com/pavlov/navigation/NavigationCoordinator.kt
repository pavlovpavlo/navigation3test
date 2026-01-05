package com.pavlov.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavKey
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class NavigationCoordinator @Inject constructor() {
    private val pendingResults = mutableMapOf<String, Any>()
    val _pendingResults = pendingResults

    fun <T : Any> setResult(resultKey: String, result: T) {
        pendingResults[resultKey] = result
    }

    inline fun <reified T : Any> getResult(resultKey: String): T? {
        return (_pendingResults.remove(resultKey) as? T)
    }

    val backStack: SnapshotStateList<NavKey> = mutableStateListOf(SplashKey)

    val currentKey: NavKey
        get() = backStack.lastOrNull() ?: SplashKey

    fun shouldShowBottomBar(): Boolean {
        return currentKey in TOP_LEVEL_KEYS
    }

    fun navigate(
        key: NavKey,
        popUpTo: NavKey? = null,
        inclusive: Boolean = false
    ) {
        if (popUpTo != null) {
            popBackTo(popUpTo, inclusive)
        }

        if (key in TOP_LEVEL_KEYS) {
            navigateToTab(key)
        } else {
            if (backStack.lastOrNull() != key) {
                backStack.add(key)
            }
        }
    }

    fun popBackTo(key: NavKey, inclusive: Boolean = false) {
        val index = backStack.indexOfLast { it == key }

        if (index != -1) {
            val removeFrom = if (inclusive) index else index + 1
            if (removeFrom < backStack.size) {
                backStack.subList(removeFrom, backStack.size).clear()
            }
        }
    }


    fun goBack() {
        if (backStack.size > 1) {
            backStack.remove(backStack.last())
        }
    }

    fun navigateAndClearBackStack(key: NavKey) {
        backStack.clear()
        backStack.add(key)
    }

    private fun navigateToTab(tabKey: NavKey) {
        val firstTabIndex = backStack.indexOfFirst { it in TOP_LEVEL_KEYS }

        if (firstTabIndex != -1) {
            if (firstTabIndex + 1 < backStack.size) {
                backStack.subList(firstTabIndex + 1, backStack.size).clear()
            }

            val currentTab = backStack[firstTabIndex]
            if (tabKey != HomeKey && tabKey != currentTab) {
                backStack.add(tabKey)
            } else if (tabKey == currentTab) {
            } else {
                backStack[firstTabIndex] = HomeKey
            }
        } else {
            backStack.add(tabKey)
        }
    }

    companion object {
        val TOP_LEVEL_KEYS = listOf(HomeKey, ProductsKey, ProfileKey)
    }
}