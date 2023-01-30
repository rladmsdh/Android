package data.repository

import data.api.loginApiProvider
import data.model.LoginRequest
import data.model.LoginResponse
import io.reactivex.Single
import retrofit2.Response

class LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> =
        loginApiProvider.login(loginRequest)
}