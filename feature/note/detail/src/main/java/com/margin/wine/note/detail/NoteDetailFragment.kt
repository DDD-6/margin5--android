package com.margin.wine.note.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.margin.wine.domain.model.WineNote
import com.margin.wine.note.detail.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {

    private val binding by lazy { FragmentNoteDetailBinding.inflate(layoutInflater) }
    private val noteDetailViewModel by viewModels<NoteDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding(WineNote.mock())
    }

    private fun initBinding(wineNote: WineNote) = with(binding) {
        title.text = wineNote.title
        date.text = wineNote.date
        inputText.text = wineNote.note
        wineNameBody.text = wineNote.wine.name
        winePriceBody.text = wineNote.wine.price.toString()
        wineTypeBody.text = wineNote.wine.type
        wineCountryBody.text = wineNote.wine.country
        wineAlcoholContentBody.text = wineNote.wine.alcoholContent.toString()
        wineBodyBody.text = wineNote.body.toString()
        wineSweetBody.text = wineNote.sweet.toString()
        wineAcidBody.text = wineNote.acid.toString()
        wineFlavorBody.text = wineNote.scentOne + " / " + wineNote.scentTwo + " / " + wineNote.scentThree //.joinToString(separator = " / ")


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