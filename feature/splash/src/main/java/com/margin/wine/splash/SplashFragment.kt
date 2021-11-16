package com.margin.wine.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.margin.wine.navigator.NavigationFlow
import com.margin.wine.navigator.ToFlowNavigate
import com.margin.wine.splash.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    
    private val binding by lazy { FragmentSplashBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        view.findViewById<Button>(R.id.move_to_main).setOnClickListener {
            (requireActivity() as ToFlowNavigate).navigateToFlow(NavigationFlow.WineFlow)
        }
    }
    
    private fun FragmentSplashBinding.initRecyclerView() {
        moveToMain.text = "asdf"
    }
}