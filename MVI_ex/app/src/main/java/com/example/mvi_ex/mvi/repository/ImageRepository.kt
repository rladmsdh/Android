package com.example.mvi_ex.mvi.repository

import com.example.mvi_ex.mvi.model.Image

interface ImageRepository {
    suspend fun getRandomImage(): Image
}