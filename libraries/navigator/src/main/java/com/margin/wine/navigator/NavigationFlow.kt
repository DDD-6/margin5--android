package com.margin.wine.navigator

sealed class NavigationFlow {
    object WineFlow : NavigationFlow()

    object Sign : NavigationFlow()
    object SignStepOne : NavigationFlow()

    object WriteNote : NavigationFlow()

    data class NoteDetail(val id: Int) : NavigationFlow()
}