package com.azimuton.funnygify.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azimuton.domain.model.Data
import com.azimuton.domain.usecase.GetGifsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListGifyViewModel @Inject constructor(
    private val getGifsUseCase: GetGifsUseCase
) : ViewModel() {

    private var _listDataTrends  = MutableLiveData<Data>()
    val listDataTrends : LiveData<Data> get() = _listDataTrends

    fun getListGifsTrends(){
        getGifsUseCase.execute()
    }
}