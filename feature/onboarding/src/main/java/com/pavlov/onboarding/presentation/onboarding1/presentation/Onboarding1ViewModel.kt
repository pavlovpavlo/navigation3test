package com.pavlov.onboarding.presentation.onboarding1.presentation

import com.pavlov.onboarding.presentation.onboarding1.presentation.mvi.Onboarding1Effect
import com.pavlov.onboarding.presentation.onboarding1.presentation.mvi.Onboarding1Intent
import com.pavlov.onboarding.presentation.onboarding1.presentation.mvi.Onboarding1State
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Onboarding1ViewModel @Inject constructor() : BaseViewModel<Onboarding1State, Onboarding1Effect>(Onboarding1State()) {

    fun onIntent(intent: Onboarding1Intent) {
        when (intent) {
            Onboarding1Intent.OnNextClicked -> {
                publishEffect(Onboarding1Effect.NavigateToOnboarding2)
            }
        }
    }
}

