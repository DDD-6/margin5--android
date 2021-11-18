package com.margin.wine.sign

import androidx.lifecycle.viewModelScope
import com.margin.wine.core.arch.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignViewModel @Inject constructor() :
    MviViewModel<SignContract.Event, SignContract.State, SignContract.Effect>() {

    override fun createInitialState(): SignContract.State {
        return SignContract.State(SignContract.SignDataState.Idle)
    }
    
    override fun handleEvent(event: SignContract.Event) {
        when(event) {
            is SignContract.Event.OnCreateAndGetMainData -> getSignData()
        }
    }
    
    private fun getSignData() = viewModelScope.launch {
        setState { copy(mainDataState = SignContract.SignDataState.Loading) }
        delay(2000L)

        /*val count = (fetchHomeWineListUseCase.invoke().getOrNull() ?: listOf()).count()
        setState { copy(mainDataState = SignContract.SignDataState.Success(count)) }*/
    }
}