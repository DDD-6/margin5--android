package com.margin.wine.navigator

sealed class NavigationFlow {
    object WineFlow : NavigationFlow()

    object Sign : NavigationFlow()
    object SignStepOne : NavigationFlow()
}