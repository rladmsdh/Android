package domain.usecase

import domain.repository.LoginRepository


class InsertLoginUseCase(private val repository: LoginRepository) {
    fun execute(sucess : Boolean){
        repository.autoLogin = sucess
    }

}