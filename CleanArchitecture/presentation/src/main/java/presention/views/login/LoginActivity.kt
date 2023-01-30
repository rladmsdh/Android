package presention.views.login

import androidx.lifecycle.ViewModelProvider
import com.example.presentation.R
import com.example.presentation.databinding.ActivityLoginBinding
import data.repository.LoginRepository
import presention.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(
    R.layout.activity_login
) {
    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProvider(this, LoginViewModelFactory(loginRepository))[LoginViewModel::class.java]
    }


    private fun initLoginButton() {
        binding.btnMove.setOnClickListener {
            val id = binding.id.text.toString()
            val passowrd = binding.password.text.toString()

            if (id.isNotBlank() && passowrd.isNotBlank()) {
                loginViewModel.postLogin(id, passowrd)
            }
        }
    }

    override fun initView() {
        initLoginButton()
    }

    override fun observeEvent() {
        loginViewModel.loginResponse.observe(
            this
        ) {
            when (it.code()) {
                200 -> {
                    showShortToast("로그인이 되었습니다.")
                }
                400 -> showShortToast("요청 형식을 식별할 수 없습니다.")

                401 -> showShortToast("비밀번호가 일치하지 않습니다.")

                404 -> showShortToast("요청 대상을 찾을 수 없습니다.")
            }
        }
    }
}
