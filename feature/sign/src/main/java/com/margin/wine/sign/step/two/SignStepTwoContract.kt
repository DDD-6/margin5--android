package com.margin.wine.sign.step.two

import com.margin.wine.core.arch.UiEffect
import com.margin.wine.core.arch.UiEvent
import com.margin.wine.core.arch.UiState

class SignStepTwoContract {

    sealed class Event: UiEvent {
        data class OnChangedInputText(val str: String) : Event()
    }

    data class State(
        val signDataState: SignDataState
    ) : UiState

    sealed class SignDataState {
        object Init : SignDataState()
        data class InputText(
            val text: String,
            val guideText: String,
            val isClearInputText: Boolean,
            val isClickableBottomButton: Boolean
        ) : SignDataState()
        data class Success(val count: Int) : SignDataState()
    }

    sealed class Effect : UiEffect {
        object ShowToast: Effect()
    }
}