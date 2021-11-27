package com.margin.wine.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.margin.wine.main.databinding.FragmentMainBinding
import com.margin.wine.navigator.NavigationFlow
import com.margin.wine.navigator.ToFlowNavigate
import com.margin.wine.note.detail.NoteDetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel by viewModels<MainViewModel>()
    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun focusTab(isTastingNote: Boolean) {
        if (isTastingNote) {
            binding.tastingNote.setBackgroundResource(R.drawable.bg_select_note_tap)
            binding.tastingNote.setTextColor(Color.WHITE)
            binding.todayRecommendWine.setBackgroundResource(R.drawable.bg_select_recommend_off)
            binding.todayRecommendWine.setTextColor(resources.getColor(R.color.color_333333, null))
            binding.pager.currentItem = 0
        } else {
            binding.tastingNote.setBackgroundResource(R.drawable.bg_select_note_tap_off)
            binding.tastingNote.setTextColor(resources.getColor(R.color.color_333333, null))
            binding.todayRecommendWine.setBackgroundResource(R.drawable.bg_select_recommend_tap)
            binding.todayRecommendWine.setTextColor(Color.WHITE)
            binding.pager.currentItem = 1
        }
    }

    private fun initTitle() {
        binding.title.text = listOf(
            "도영님,\n환영합니다.\uD83D\uDC4F",
            "오늘도 수고한 당신\n와인이 위로하네 \uD83C\uDFB5",
            "내추럴와인을 즐기는 도영님\n생각보다 한 수 위네? \uD83E\uDD23"
        ).shuffled().first()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //args.eventId.toString()
        initTitle()
        binding.tastingNote.setOnClickListener { focusTab(true) }
        binding.todayRecommendWine.setOnClickListener { focusTab(false) }

        /*requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })*/
        
        render()
        effects()
    
        mainViewModel.setEvent(MainContract.Event.OnCreateAndGetMainData)

        initPager()

        binding.write.setOnClickListener {
            (requireActivity() as ToFlowNavigate).navigateToFlow(NavigationFlow.WriteNote)
        }
    }

    private fun initPager() = with(binding.pager){
        adapter = MainPagerAdapter(requireActivity())
        isSaveEnabled = false
        registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0) focusTab(true)
                else focusTab(false)
            }
        })
    }
    
    private fun render() = lifecycleScope.launchWhenStarted {
        mainViewModel.uiState.collect {
            when(val state = it.mainDataState) {
                is MainContract.MainDataState.Idle -> {} //binding.mainProgress.isVisible = false
                is MainContract.MainDataState.Loading -> {} //binding.mainProgress.isVisible = true
                is MainContract.MainDataState.Success -> {
                    //binding.mainProgress.isVisible = false
                    //binding.wineCount.text = state.count.toString()
                    //binding.mainListView.adapter = ThumbnailListAdapter(ThumbnailViewState.mock())
                }
            }
        }
    }
    
    private fun effects() = lifecycleScope.launchWhenStarted {
        mainViewModel.effect.collect { effect ->
            when(effect) {
                is MainContract.Effect.ShowToast -> {
                    //binding.mainProgress.isVisible = false
                    Toast.makeText(requireContext(), "Wine", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}