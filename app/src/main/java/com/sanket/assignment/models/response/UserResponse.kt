package com.sanket.assignment.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
    @Expose
    @SerializedName("company")
    val company: Company?,

    @Expose
    @SerializedName("website")
    val website: String?,

    @Expose
    @SerializedName("phone")
    val phone: String?,

    @Expose
    @SerializedName("address")
    val address: Address?,

    @Expose
    @SerializedName("email")
    val email: String?,

    @Expose
    @SerializedName("username")
    val username: String?,

    @Expose
    @SerializedName("name")
    val name: String?,

    @Expose
    @SerializedName("id")
    val id: Int,
) : Serializable

class Company(
    @Expose
    @SerializedName("bs")
    val bs: String?,

    @Expose
    @SerializedName("catchPhrase")
    val catchPhrase: String?,

    @Expose
    @SerializedName("name")
    val name: String?,
): Serializable

data class Address(
    @Expose
    @SerializedName("geo")
    val geo: Geo?,

    @Expose
    @SerializedName("zipcode")
    val zipcode: String?,

    @Expose
    @SerializedName("city")
    val city: String?,

    @Expose
    @SerializedName("suite")
    val suite: String?,

    @Expose
    @SerializedName("street")
    val street: String?
): Serializable

data class Geo(
    @Expose
    @SerializedName("lng")
    val lng: String?,

    @Expose
    @SerializedName("lat")
    val lat: String?
): Serializable
