package com.example.data.data.util

import com.example.domain.domain.exception.BadRequestException
import com.example.domain.domain.exception.ConflictException
import com.example.domain.domain.exception.NotFoundException
import com.example.domain.domain.exception.OtherException
import retrofit2.HttpException

class HttpHandler<T> {

    private lateinit var httpRequest: suspend () -> T
    private val onBadRequest: (message: String) -> Throwable = { BadRequestException() }
    private val onNotFound: (message: String) -> Throwable = { NotFoundException() }
    private val onConflict: (message: String) -> Throwable = { ConflictException() }
    private val onOtherException: (code: Int, message: String) -> Throwable = { _, _ -> OtherException() }

    fun httpRequest(httpRequest: suspend () -> T) =
        this.apply { this.httpRequest = httpRequest }

    suspend fun sendRequest(): T =
        try {
            httpRequest()
        } catch (e: HttpException) {
            val code = e.code()
            val message = e.message()
            throw when (code) {
                400 -> onBadRequest(message)
                404 -> onNotFound(message)
                409 -> onConflict(message)
                else -> onOtherException(code, message)
            }
        }
}


