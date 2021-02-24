package com.sanket.assignment.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanket.assignment.models.response.UserResponse
import com.sanket.assignment.repository.MainRepository
import com.sanket.assignment.utils.NetworkResult

class MainViewModel : ViewModel() {
    val mainRepository: MainRepository

    init {
        mainRepository = MainRepository()
    }

    fun getUserList(): MutableLiveData<NetworkResult<List<UserResponse>>> {
        return mainRepository.getUsers()
    }
}