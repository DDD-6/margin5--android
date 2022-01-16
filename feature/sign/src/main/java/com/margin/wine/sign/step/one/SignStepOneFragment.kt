package com.margin.wine.sign.step.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.margin.wine.sign.databinding.FragmentSignStepOneBinding
import kotlinx.coroutines.flow.collect

class SignStepOneFragment : Fragment() {

    private val binding by lazy { FragmentSignStepOneBinding.inflate(layoutInflater) }
    private val signStepOneViewModel by viewModels<SignStepOneViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        render()
        effects()
    }

    private fun render() = lifecycleScope.launchWhenStarted {
        signStepOneViewModel.uiState.collect {
            when(val state = it.signDataState) {
                is SignStepOneContract.SignDataState.Init -> binding.btnNext.enabled(state.isClickableBottomButton)
                is SignStepOneContract.SignDataState.InputText -> {
                    binding.signStepOneGuide.text = state.guideText
                    binding.inputClearBtn.isVisible = state.isClearInputText
                    binding.btnNext.enabled(state.isClickableBottomButton)
                }
            }
        }
    }

    private fun effects() = lifecycleScope.launchWhenStarted {
        signStepOneViewModel.effect.collect { effect ->
            when(effect) {
                is SignStepOneContract.Effect.ShowToast -> {  }
            }
        }
    }

    private fun initViews() = with(binding) {
        signStepOneInput.initEditText()
        btnNext.initBottomBtn()
    }

    private fun Button.initBottomBtn() {
        setOnClickListener {
            signStepOneViewModel.setEvent(SignStepOneContract.Event.OnClickNext)
            findNavController().navigate(SignStepOneFragmentDirections.actionSignStepOneFragmentToSignStepTwoFragment())
        }
    }

    private fun EditText.initEditText() {
        addTextChangedListener {
            signStepOneViewModel.setEvent(SignStepOneContract.Event.OnChangedInputText(it.toString()))
        }
    }
}