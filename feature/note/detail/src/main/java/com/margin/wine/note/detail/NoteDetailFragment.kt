package com.margin.wine.note.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.margin.wine.core.ext.toast
import com.margin.wine.domain.Result
import com.margin.wine.domain.model.WineNote
import com.margin.wine.note.detail.databinding.FragmentNoteDetailBinding
import com.solar.library.materialbottomsheet.BottomSheetConfig
import com.solar.library.materialbottomsheet.BottomSheetItem
import com.solar.library.materialbottomsheet.BottomSheetType
import com.solar.library.materialbottomsheet.MaterialBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {

    private val binding by lazy { FragmentNoteDetailBinding.inflate(layoutInflater) }
    private val noteDetailViewModel by viewModels<NoteDetailViewModel>()
    private val args by navArgs<NoteDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initBinding(WineNote.mock())
        println("id : ${args.id}")

        lifecycleScope.launchWhenStarted {
            noteDetailViewModel.wineNoteFlow.collect { result ->
                when(result) {
                    is Result.Loading -> { }
                    is Result.Success -> initBinding(result.data)
                    is Result.Error -> { }
                }
            }

            noteDetailViewModel.wineNoteDeleteFlow.collect { result ->
                when(result) {
                    is Result.Loading -> { }
                    is Result.Success -> {
                        requireContext().toast(result.data)
                        findNavController().navigateUp()
                    }
                    is Result.Error -> { }
                }
            }
        }

        binding.inputText.setLineColor(Color.BLACK)
        binding.inputText.setLineWeight(2.0f)
        binding.inputText.addSpaceHeight(12)

        noteDetailViewModel.loadWineNote(args.id)
    }

    private fun initBinding(wineNote: WineNote) = with(binding) {
        more.setOnClickListener {
            MaterialBottomSheet(requireContext())
                .items(listOf(
                    BottomSheetItem("삭제")
                )) // List of 'BottomSheetItem'
                .setRippleEffect(true) // Default is true
                .type(BottomSheetType.LIST) // LIST, GRID
                .select { index, item ->
                    when(index) {
                        0 -> {
                            noteDetailViewModel.delete(args.id)
                        }
                    }
                }
                .show()
        }
        title.text = wineNote.title
        date.text = wineNote.date
        inputText.text = wineNote.note
        wineNameBody.text = wineNote.wine.name
        winePriceBody.text = wineNote.wine.price.toString()
        wineTypeBody.text = wineNote.wine.type
        wineCountryBody.text = wineNote.wine.country
        wineAlcoholContentBody.text = wineNote.wine.alcoholContent.toString() + "%"
        wineBodyBody.text = wineNote.body.toString()
        wineSweetBody.text = wineNote.sweet.toString()
        wineAcidBody.text = wineNote.acid.toString()
        wineFlavorBody.text = wineNote.scentOne + " / " + wineNote.scentTwo + " / " + wineNote.scentThree //.joinToString(separator = " / ")

        binding.imgPager.adapter = ImagePagerAdapter(List(5) { "" })

        binding.cardImg.setImageResource(
            when(wineNote.cardType) {
                1 -> R.drawable.ic_man
                2 -> R.drawable.ic_woman
                3 -> R.drawable.ic_couple
                4 -> R.drawable.ic_mans
                else -> R.drawable.ic_womans
            }
        )

        when(wineNote.rating) {
            1 -> {
                rating1.setImageResource(R.drawable.ic_favorite_on)
            }
            2 -> {
                rating1.setImageResource(R.drawable.ic_favorite_on)
                rating2.setImageResource(R.drawable.ic_favorite_on)
            }
            3 -> {
                rating1.setImageResource(R.drawable.ic_favorite_on)
                rating2.setImageResource(R.drawable.ic_favorite_on)
                rating3.setImageResource(R.drawable.ic_favorite_on)
            }

            4 -> {
                rating1.setImageResource(R.drawable.ic_favorite_on)
                rating2.setImageResource(R.drawable.ic_favorite_on)
                rating3.setImageResource(R.drawable.ic_favorite_on)
                rating4.setImageResource(R.drawable.ic_favorite_on)
            }

            5 -> {
                rating1.setImageResource(R.drawable.ic_favorite_on)
                rating2.setImageResource(R.drawable.ic_favorite_on)
                rating3.setImageResource(R.drawable.ic_favorite_on)
                rating4.setImageResource(R.drawable.ic_favorite_on)
                rating5.setImageResource(R.drawable.ic_favorite_on)
            }
        }
    }

    fun newInstance(id: Int): NoteDetailFragment {
        val args = Bundle().apply {
            putInt("id", id)
        }

        val fragment = NoteDetailFragment()
        fragment.arguments = args
        return fragment
    }
}