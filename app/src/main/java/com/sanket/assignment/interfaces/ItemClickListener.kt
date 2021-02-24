package com.sanket.assignment.interfaces

import com.sanket.assignment.models.response.UserResponse

interface ItemClickListener {
    fun onItemClicked(userResponse: UserResponse)
}