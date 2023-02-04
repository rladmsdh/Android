package com.example.data.data.usecase

import data.model.LoginParam
import data.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository){
    suspend fun excute(data: LoginParam) {
        loginRepository.login(data)
    }
}