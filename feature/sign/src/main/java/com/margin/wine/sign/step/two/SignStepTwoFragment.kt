package com.margin.wine.sign.step.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.margin.wine.sign.databinding.FragmentSignStepTwoBinding

class SignStepTwoFragment : Fragment() {

    private val binding by lazy { FragmentSignStepTwoBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SignStepTwoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomBtn.initBottomBtn()
    }

    private fun Button.initBottomBtn() {
        setOnClickListener {
            findNavController().navigate(SignStepTwoFragmentDirections.actionSignStepTwoFragmentToSignFinishFragment())
        }
    }
}