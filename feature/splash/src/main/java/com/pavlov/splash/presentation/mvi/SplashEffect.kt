package com.pavlov.splash.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface SplashEffect: UiEffect {
    data object NavigateToOnboarding : SplashEffect
    data object NavigateToMain : SplashEffect
}