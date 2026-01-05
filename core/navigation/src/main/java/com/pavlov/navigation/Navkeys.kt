package com.pavlov.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Splash
@Serializable
object SplashKey : NavKey

// Onboarding
@Serializable
object Onboarding1Key : NavKey

@Serializable
object Onboarding2Key : NavKey

@Serializable
object Onboarding3Key : NavKey

// Main Tabs
@Serializable
object HomeKey : NavKey

@Serializable
object ProductsKey : NavKey

@Serializable
object ProfileKey : NavKey

// Details
@Serializable
data class ProductDetailsKey(val productId: String) : NavKey
