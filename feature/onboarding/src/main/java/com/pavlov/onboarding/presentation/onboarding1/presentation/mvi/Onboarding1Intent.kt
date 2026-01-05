package com.pavlov.onboarding.presentation.onboarding1.presentation.mvi

sealed interface Onboarding1Intent {
    data object OnNextClicked : Onboarding1Intent
}

