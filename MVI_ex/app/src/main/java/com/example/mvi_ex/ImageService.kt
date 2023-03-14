package com.example.mvi_ex

import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID Fbh97wmQ5GRV6d6KFVHkAcau_STv72JShB3Tz0x-XNg")
    @GET("photos/random")
    suspend fun getRandomImageSuspend() : ImageResponse
} 