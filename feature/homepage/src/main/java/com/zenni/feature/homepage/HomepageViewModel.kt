package com.zenni.feature.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenni.core.base.Dispatcher
import com.zenni.core.base.Dispatchers.IO
import com.zenni.core.data.repository.FrameResourceQuery
import com.zenni.core.datamodel.frame.Frame
import com.zenni.core.domain.FrameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
    private val frameUseCase: FrameUseCase,
) : ViewModel() {

    internal val framesState = MutableStateFlow<List<Frame>>(emptyList())

    val framesUiState: StateFlow<List<Frame>> =
        framesState.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    fun fetchFrameResources(
        query: FrameResourceQuery,
    ) = viewModelScope.launch(ioDispatcher) {
        frameUseCase.getFrameResources(
            query = query,
        ).collect {
            framesState.value = it
        }
    }
}
