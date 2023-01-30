package presention.views.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import data.repository.LoginRepository

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(private val loginRepository: LoginRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRepository) as T
    }
}