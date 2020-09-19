package com.utsman.sepack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.utsman.sepack.repository.MainRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val scope = viewModelScope.plus(mainRepository.scope.coroutineContext)
    val users = mainRepository.user
        .asLiveData(viewModelScope.coroutineContext)

    fun users() = scope.launch {
        mainRepository.users()
    }
}