package com.margin.wine.sign.step.two

import com.margin.wine.core.arch.MviViewModel

class SignStepTwoViewModel : MviViewModel<SignStepTwoContract.Event, SignStepTwoContract.State, SignStepTwoContract.Effect>(){

    override fun createInitialState(): SignStepTwoContract.State = SignStepTwoContract.State(SignStepTwoContract.SignDataState.Init)

    override fun handleEvent(event: SignStepTwoContract.Event) {
        when (event) {
            is SignStepTwoContract.Event.OnChangedInputText -> { }
        }
    }
}