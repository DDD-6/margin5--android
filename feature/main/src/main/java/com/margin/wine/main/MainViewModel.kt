package com.margin.wine.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.margin.wine.domain.usecase.wine.FetchHomeWineListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchHomeWineListUseCase: FetchHomeWineListUseCase
): ViewModel() {

    private val _wineCountLiveData = MutableLiveData<Int>()
    val wineCountLiveData: LiveData<Int> get() = _wineCountLiveData

    init {
        viewModelScope.launch {
            val count = (fetchHomeWineListUseCase.invoke().getOrNull() ?: listOf()).count()
            _wineCountLiveData.postValue(count)
        }
    }
}