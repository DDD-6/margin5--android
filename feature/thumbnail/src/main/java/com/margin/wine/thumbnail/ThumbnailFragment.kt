package com.margin.wine.thumbnail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.navigator.NavigationFlow
import com.margin.wine.navigator.ToFlowNavigate
import com.margin.wine.thumbnail.databinding.FragmentThumbnailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ThumbnailFragment : Fragment() {

    private val thumbnailViewModel by viewModels<ThumbnailViewModel>()
    private val binding by lazy { FragmentThumbnailBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launchWhenStarted {
            thumbnailViewModel.wineNoteList.collect {
                if (it.size > 1) {
                    binding.thumbnailList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
                }
                binding.thumbnailList.adapter = ThumbnailListAdapter(it) { id ->
                    when(id) {
                        -1 -> (requireActivity() as ToFlowNavigate).navigateToFlow(NavigationFlow.WriteNote)
                        else -> (requireActivity() as ToFlowNavigate).navigateToFlow(NavigationFlow.NoteDetail(id))
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(): ThumbnailFragment{
            val args = Bundle()

            val fragment = ThumbnailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}