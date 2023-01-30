package presention.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.LoginRequest
import data.model.LoginResponse
import data.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginViewModel (
    private val loginRepository: LoginRepository
):ViewModel() {

    private val _loginResponse = MutableLiveData<Response<LoginResponse>>()
    val loginResponse : LiveData<Response<LoginResponse>> = _loginResponse

    fun postLogin(
        id:String,
        password:String
    ){
        val loginRequest = LoginRequest(id,password)
        viewModelScope.launch(Dispatchers.IO) {
            _loginResponse.postValue(loginRepository.login(loginRequest))
        }
    }
}