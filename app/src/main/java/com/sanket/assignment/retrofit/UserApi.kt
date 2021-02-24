package com.sanket.assignment.retrofit

import com.sanket.assignment.models.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    fun getUsers(): Single<List<UserResponse>>
}