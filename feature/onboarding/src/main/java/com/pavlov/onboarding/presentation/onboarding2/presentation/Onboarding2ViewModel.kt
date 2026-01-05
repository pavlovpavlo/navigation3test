package com.pavlov.onboarding.presentation.onboarding2.presentation

import com.pavlov.onboarding.presentation.onboarding2.presentation.mvi.Onboarding2Effect
import com.pavlov.onboarding.presentation.onboarding2.presentation.mvi.Onboarding2Intent
import com.pavlov.onboarding.presentation.onboarding2.presentation.mvi.Onboarding2State
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Onboarding2ViewModel @Inject constructor() : BaseViewModel<Onboarding2State, Onboarding2Effect>(Onboarding2State()) {

    fun onIntent(intent: Onboarding2Intent) {
        when (intent) {
            Onboarding2Intent.OnNextClicked -> {
                publishEffect(Onboarding2Effect.NavigateToOnboarding3)
            }
        }
    }
}

