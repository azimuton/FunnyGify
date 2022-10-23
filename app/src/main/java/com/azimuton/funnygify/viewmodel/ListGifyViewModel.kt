package com.azimuton.funnygify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azimuton.domain.usecase.GetGifsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListGifyViewModel @Inject constructor(
    private val getGifsUseCase: GetGifsUseCase
) : ViewModel() {

    fun getListGifsTrends() {
        viewModelScope.launch(Dispatchers.IO) {
            getGifsUseCase.execute()
        }


    }
}