package com.sanket.assignment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sanket.assignment.models.response.UserResponse
import com.sanket.assignment.retrofit.RetrofitClient
import com.sanket.assignment.retrofit.UserApi
import com.sanket.assignment.utils.NetworkResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository() {
    val userApi: UserApi
    val compositeDisposable: CompositeDisposable

    init {
        userApi = RetrofitClient.create()
        compositeDisposable = CompositeDisposable()
    }

    fun getUsers(): MutableLiveData<NetworkResult<List<UserResponse>>> {
        val mutableLiveData = MutableLiveData<NetworkResult<List<UserResponse>>>()
        compositeDisposable.add(
            userApi.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.postValue(NetworkResult.Success(it))
                }, {
                    it?.message?.let {
                        mutableLiveData.postValue(NetworkResult.Error(it))
                    }

                })
        )
        return mutableLiveData
    }

    fun clear() {
        compositeDisposable.dispose()
    }
}