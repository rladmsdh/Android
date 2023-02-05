package com.example.data.data.usecase

import data.model.LoginParam
import data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun excute(data: LoginParam) {
        loginRepository.login(data)
    }
}