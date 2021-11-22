package com.margin.wine.note.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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