package com.margin.wine.wine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.margin.wine.wine.databinding.FragmentWineListBinding
import com.margin.wine.wine.model.WineListUiModel

class WineListFragment : Fragment() {

    private val binding by lazy { FragmentWineListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = WineListAdapter(WineListUiModel.mock())
        binding.wineListView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL).apply {
                ResourcesCompat.getDrawable(resources, R.drawable.item_divider, null)?.let { this.setDrawable(it) }
            }
        )
        binding.wineListView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL).apply {
                ResourcesCompat.getDrawable(resources, R.drawable.item_divider, null)?.let { this.setDrawable(it) }
            }
        )
        binding.wineListView.adapter = adapter
        binding.wineListView.layoutManager = GridLayoutManager(requireContext(), 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when(adapter.getItemViewType(position)) {
                        R.layout.item_wine_vertical -> 1
                        else -> 2
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(): WineListFragment {
            val args = Bundle()

            val fragment = WineListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}