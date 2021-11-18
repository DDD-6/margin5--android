package com.margin.wine.navigator

import androidx.navigation.NavController
import com.margin.wine.splash.SplashFragmentDirections

class Navigator {
    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) = when(navigationFlow) {
        NavigationFlow.WineFlow -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
        NavigationFlow.Sign -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToSignFragment())
        NavigationFlow.SignStepOne -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToSignFragment())
    }
}