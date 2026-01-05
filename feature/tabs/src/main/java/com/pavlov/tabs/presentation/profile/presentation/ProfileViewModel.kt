package com.pavlov.tabs.presentation.profile.presentation

import com.pavlov.tabs.presentation.profile.presentation.mvi.ProfileEffect
import com.pavlov.tabs.presentation.profile.presentation.mvi.ProfileIntent
import com.pavlov.tabs.presentation.profile.presentation.mvi.ProfileState
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel<ProfileState, ProfileEffect>(ProfileState()) {

    fun onIntent(intent: ProfileIntent) {
        // Handle intents
    }
}

