package com.margin.wine.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.margin.wine.navigator.NavigationFlow
import com.margin.wine.navigator.ToFlowNavigate
import com.margin.wine.sign.databinding.FragmentSignBinding
import kotlinx.coroutines.flow.collect

class SignFragment : Fragment() {

    private val binding by lazy { FragmentSignBinding.inflate(layoutInflater) }
    private val signViewModel by viewModels<SignViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        render()
        effects()
        initButtons()
    }

    private fun initButtons() {
        binding.signIn.setOnClickListener {
            findNavController().navigate(SignFragmentDirections.actionSignFragmentToSignStepOneFragment())
        }
    }

    private fun render() = lifecycleScope.launchWhenStarted {
        signViewModel.uiState.collect {
            /*when(val state = it.mainDataState) {
                is MainContract.MainDataState.Idle -> binding.mainProgress.isVisible = false
                is MainContract.MainDataState.Loading -> binding.mainProgress.isVisible = true
                is MainContract.MainDataState.Success -> {
                    binding.mainProgress.isVisible = false
                    binding.wineCount.text = state.count.toString()

                    binding.mainListView.adapter = ThumbnailListAdapter(ThumbnailViewState.mock())
                }
            }*/
        }
    }

    private fun effects() = lifecycleScope.launchWhenStarted {
        signViewModel.effect.collect { effect ->
            /*when(effect) {
                is MainContract.Effect.ShowToast -> {
                    binding.mainProgress.isVisible = false
                    Toast.makeText(requireContext(), "Wine", Toast.LENGTH_SHORT).show()
                }
            }*/
        }
    }
}