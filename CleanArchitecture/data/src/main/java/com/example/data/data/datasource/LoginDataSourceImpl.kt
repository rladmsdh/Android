package com.example.data.data.datasource

import com.example.data.data.util.HttpHandler
import com.example.data.data.model.LoginRequest
import com.example.data.data.model.LoginResponse
import data.api.LoginInterface
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginInterface: LoginInterface
): LoginDataSource{
    override suspend fun postLogin(loginRequest: LoginRequest) = HttpHandler<LoginResponse>()
        .httpRequest {
            loginInterface.login(
                loginRequest = loginRequest,
            )
        }.sendRequest()

}