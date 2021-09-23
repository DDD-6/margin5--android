package com.margin.wine.main

import androidx.lifecycle.viewModelScope
import com.margin.wine.core.arch.MviViewModel
import com.margin.wine.domain.usecase.wine.FetchHomeWineListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchHomeWineListUseCase: FetchHomeWineListUseCase
): MviViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    override fun createInitialState(): MainContract.State {
        return MainContract.State(MainContract.MainDataState.Idle)
    }
    
    override fun handleEvent(event: MainContract.Event) {
        when(event) {
            is MainContract.Event.OnCreateAndGetMainData -> getMainData()
        }
    }
    
    private fun getMainData() = viewModelScope.launch {
        setState { copy(mainDataState = MainContract.MainDataState.Loading) }
        delay(2000L)
        
        val count = (fetchHomeWineListUseCase.invoke().getOrNull() ?: listOf()).count()
        setState { copy(mainDataState = MainContract.MainDataState.Success(count)) }
    }
}