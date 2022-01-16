package com.margin.wine.sign.step.one

import com.margin.wine.core.arch.UiEffect
import com.margin.wine.core.arch.UiEvent
import com.margin.wine.core.arch.UiState

class SignStepOneContract {

    sealed class Event: UiEvent {
        data class OnChangedInputText(val str: String) : Event()
        object OnClickNext : Event()
    }

    data class State(
        val signDataState: SignDataState
    ) : UiState

    sealed class SignDataState {
        data class Init(
            val isClickableBottomButton: Boolean
        ) : SignDataState()
        data class InputText(
            val text: String,
            val guideText: String,
            val isClearInputText: Boolean,
            val isClickableBottomButton: Boolean
        ) : SignDataState()
    }

    sealed class Effect : UiEffect {
        object ShowToast: Effect()
    }
}