package com.margin.wine.write

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.margin.wine.write.card.WineCardSelect
import com.margin.wine.write.card.WineCardSelectAdapter
import com.margin.wine.write.databinding.FragmentWriteBinding

class WriteFragment : Fragment() {
    private val wineNoteWriteViewModel by viewModels<WriteViewModel>()
    private val binding by lazy { FragmentWriteBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listCard.adapter = WineCardSelectAdapter().apply {
            submitList(listOf(
                WineCardSelect(R.drawable.ic_couple_2)
            ))
        }
    }
}