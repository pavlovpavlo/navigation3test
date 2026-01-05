package com.pavlov.ui.view_module


import androidx.lifecycle.ViewModel
import com.pavlov.ui.coroutine.JobManager
import com.pavlov.ui.coroutine.JobManagerImpl
import com.pavlov.ui.view_module.mvi.MVI
import com.pavlov.ui.view_module.mvi.ModelViewIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel<State : UiState, Effect : UiEffect>(
    initialState: State
) : ViewModel(),
    MVI<State, Effect> by ModelViewIntent(initialState) {

    protected val jobManager: JobManager = JobManagerImpl()

    val viewModelScope: CoroutineScope by lazy {
        CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }


    override fun onCleared() {
        super.onCleared()
        cancelMviScope()
        viewModelScope.cancel()
        jobManager.cancelAll()
    }
}