package com.example.data.data.datasource

import com.example.data.data.model.LoginRequest
import com.example.data.data.model.LoginResponse

interface LoginDataSource {
    suspend fun postLogin(loginRequest: LoginRequest):LoginResponse
}