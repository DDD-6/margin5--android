package com.margin.wine.navigator

import androidx.navigation.NavController
import com.margin.wine.main.MainFragmentDirections
import com.margin.wine.splash.SplashFragmentDirections

class Navigator {
    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) = when(navigationFlow) {
        is NavigationFlow.WineFlow -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
        is NavigationFlow.Sign -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToSignFragment())
        is NavigationFlow.SignStepOne -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToSignFragment())
        is NavigationFlow.WriteNote -> navController.navigate(MainFragmentDirections.actionMainFragmentToNoteWriteFragment())
        is NavigationFlow.NoteDetail -> navController.navigate(MainFragmentDirections.actionMainFragmentToNoteDetailFragment().also {
            it.id = navigationFlow.id
        })
    }
}