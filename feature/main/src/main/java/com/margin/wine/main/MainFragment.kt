package com.margin.wine.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.margin.wine.main.databinding.FragmentMainBinding
import com.margin.wine.thumbnail.ThumbnailListAdapter
import com.margin.wine.thumbnail.ThumbnailViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel by viewModels<MainViewModel>()
    private val args by navArgs<MainFragmentArgs>()
    
    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //args.eventId.toString()

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
        
        render()
        effects()
    
        mainViewModel.setEvent(MainContract.Event.OnCreateAndGetMainData)
    }
    
    private fun render() = lifecycleScope.launchWhenStarted {
        mainViewModel.uiState.collect {
            when(val state = it.mainDataState) {
                is MainContract.MainDataState.Idle -> binding.mainProgress.isVisible = false
                is MainContract.MainDataState.Loading -> binding.mainProgress.isVisible = true
                is MainContract.MainDataState.Success -> {
                    binding.mainProgress.isVisible = false
                    binding.wineCount.text = state.count.toString()

                    binding.mainListView.adapter = ThumbnailListAdapter(ThumbnailViewState.mock())
                }
            }
        }
    }
    
    private fun effects() = lifecycleScope.launchWhenStarted {
        mainViewModel.effect.collect { effect ->
            when(effect) {
                is MainContract.Effect.ShowToast -> {
                    binding.mainProgress.isVisible = false
                    Toast.makeText(requireContext(), "Wine", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}