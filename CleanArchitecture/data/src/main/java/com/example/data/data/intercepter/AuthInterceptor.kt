package com.example.data.data.intercepter

import com.example.data.data.storage.UserDataStorage
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val userDataStorage: UserDataStorage,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url().encodedPath()

        val ignorePath = arrayListOf(
            "/users/login"
        )

        if (ignorePath.contains(path)) {
            return chain.proceed(request)
        }

        val accessToken = userDataStorage.fetchAccessToken()

        return chain.proceed(
            request.newBuilder()
                .addHeader("Authorization", accessToken)
                .build()
        )
    }

}