package data.api

import data.api.ApiClient.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl(BASE_URL)
    addConverterFactory(GsonConverterFactory.create())
}.build()

val loginApiProvider: LoginInterface by lazy {
    retrofit.create(LoginInterface::class.java)
}
