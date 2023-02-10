package com.example.presentation_compose.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.data.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import data.model.LoginParam
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
):ViewModel() {

    private val _loginEvent = MutableSharedFlow<Event>()
    val loginEvent
        get() = _loginEvent.asSharedFlow()

    internal fun postLogin(
        id:String,
        password:String,
    ){
        viewModelScope.launch{
            runCatching {
                loginUseCase.excute(
                    LoginParam(
                        account_id = id,
                        password = password,
                    )
                )
            }.onSuccess {
                _loginEvent.emit(Event.ToastToLoginActivity)
            }
        }
    }
    sealed class Event {
        object ToastToLoginActivity : Event()
    }
}