package data.api

import com.example.data.data.model.LoginRequest
import com.example.data.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("/user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : LoginResponse
}