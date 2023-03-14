package com.example.mvi_ex.mvi.repository

import com.example.mvi_ex.RetrofitManager
import com.example.mvi_ex.mvi.model.Image
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    ImageRepository {
    override suspend fun getRandomImage() = withContext(dispatcher) {
        RetrofitManager.imageService.getRandomImageSuspend().let {
            Image(it.urls.regular,it.color)
        }
    }

}