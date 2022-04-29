package com.example.hilt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.data.entity.HiltEntity
import com.example.hilt.data.repositorty.HiltRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val hiltRepository: HiltRepository
) : ViewModel(){

    fun fetchData() : Job = viewModelScope.launch{
    }
}