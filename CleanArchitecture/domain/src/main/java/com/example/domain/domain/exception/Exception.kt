package com.example.domain.domain.exception

class BadRequestException(): Throwable() // 400
class NotFoundException(): Throwable() // 404
class ConflictException(): Throwable() // 409
class OtherException(): Throwable()
class UnAuthorizationException() : Throwable()