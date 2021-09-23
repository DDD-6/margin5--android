package com.margin.wine.main

import com.margin.wine.core.arch.UiEffect
import com.margin.wine.core.arch.UiEvent
import com.margin.wine.core.arch.UiState

class MainContract {
	
	sealed class Event: UiEvent {
		object OnCreateAndGetMainData : Event()
	}
	
	data class State(
		val mainDataState: MainDataState
	) : UiState
	
	sealed class MainDataState {
		object Idle : MainDataState()
		object Loading : MainDataState()
		data class Success(val count: Int) : MainDataState()
	}
	
	sealed class Effect : UiEffect {
		object ShowToast: Effect()
	}
}