package com.pavlov.onboarding.presentation.onboarding3.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface Onboarding3Effect : UiEffect {
    data object NavigateToHome : Onboarding3Effect
}

