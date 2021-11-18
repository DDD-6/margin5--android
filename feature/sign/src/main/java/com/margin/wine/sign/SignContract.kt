package com.margin.wine.sign

import com.margin.wine.core.arch.UiEffect
import com.margin.wine.core.arch.UiEvent
import com.margin.wine.core.arch.UiState

class SignContract {
	
	sealed class Event: UiEvent {
		object OnCreateAndGetMainData : Event()
	}
	
	data class State(
		val mainDataState: SignDataState
	) : UiState
	
	sealed class SignDataState {
		object Idle : SignDataState()
		object Loading : SignDataState()
		data class Success(val count: Int) : SignDataState()
	}
	
	sealed class Effect : UiEffect {
		object ShowToast: Effect()
	}
}