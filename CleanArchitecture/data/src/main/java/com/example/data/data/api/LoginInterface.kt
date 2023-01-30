package data.api

import data.model.LoginRequest
import data.model.LoginResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("/user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : Response<LoginResponse>
}