package com.example.hilt.ui.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.data.entity.HiltEntity
import com.example.hilt.data.repositorty.HiltRepository
import com.example.hilt.util.lifecycle.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val hiltRepository: HiltRepository
) : ViewModel() {

    var list = MutableLiveData<List<HiltEntity>>()
    val clickEvent = SingleLiveEvent<Unit>(300)

    fun fetchData(): Job = viewModelScope.launch {
        list.value = hiltRepository.getEntityList()
    }

    fun clickButton() = viewModelScope.launch {
        clickEvent.call()
        hiltRepository.insertEntity(HiltEntity(name = "ㅎㅎ..."))
//        fetchData()
    }
}