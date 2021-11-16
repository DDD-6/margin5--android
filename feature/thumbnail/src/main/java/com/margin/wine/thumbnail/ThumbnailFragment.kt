package com.margin.wine.thumbnail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.margin.wine.thumbnail.databinding.FragmentThumbnailBinding

class ThumbnailFragment : Fragment() {

    private val binding by lazy { FragmentThumbnailBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.thumbnailList.adapter = ThumbnailListAdapter(ThumbnailViewState.mock())
    }
}