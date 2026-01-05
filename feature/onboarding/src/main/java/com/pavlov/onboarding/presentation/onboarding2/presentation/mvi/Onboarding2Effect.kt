package com.pavlov.onboarding.presentation.onboarding2.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface Onboarding2Effect : UiEffect {
    data object NavigateToOnboarding3 : Onboarding2Effect
}

