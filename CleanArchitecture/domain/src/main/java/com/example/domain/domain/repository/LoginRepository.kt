package data.repository

import data.model.LoginParam

interface LoginRepository {
    suspend fun login(param: LoginParam)
}

