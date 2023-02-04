package com.example.data.data.repository

import com.example.data.data.datasource.LoginDataSource
import com.example.data.data.model.LoginRequest
import data.model.LoginParam
import data.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
) : LoginRepository{
    private fun toRequest(param: LoginParam): LoginRequest = LoginRequest(
        account_id = param.account_id,
        password = param.password,
    )
    override suspend fun login(param: LoginParam) {
        loginDataSource.postLogin(loginRequest = toRequest(param))

    }

}