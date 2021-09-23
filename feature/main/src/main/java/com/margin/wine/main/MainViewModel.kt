package com.margin.wine.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.margin.wine.data.source.repository.WineRepositoryImpl
import com.margin.wine.domain.usecase.wine.FetchHomeWineListUseCase
import com.margin.wine.local.datasource.WineLocalDataSourceImpl
import com.margin.wine.remote.source.WineRemoteDataSourceImpl
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val fetchHomeWineListUseCase = FetchHomeWineListUseCase(
        WineRepositoryImpl(
            WineRemoteDataSourceImpl(),
            WineLocalDataSourceImpl()
        )
    )

    private val _wineCountLiveData = MutableLiveData<Int>()
    val wineCountLiveData: LiveData<Int> get() = _wineCountLiveData

    init {
        viewModelScope.launch {
            val count = (fetchHomeWineListUseCase.invoke().getOrNull() ?: listOf()).count()
            _wineCountLiveData.postValue(count)
        }
    }
}