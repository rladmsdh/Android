package com.example.data.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("id")
    val account_id : String,
    @SerializedName("password")
    val password : String,
)

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
)