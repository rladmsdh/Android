package presentation.views.login

import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import presentation.base.BaseActivity

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(
    R.layout.activity_login
) {
    private val viewModel by viewModels<LoginViewModel>()

    private fun initLoginButton() {
        binding.btnMove.setOnClickListener {
            val id = binding.id.text.toString()
            val password = binding.password.text.toString()

            if (id.isNotBlank() && password.isNotBlank()) {
                postLogin(
                    id = id,
                    password = password,
                )
            }
        }
    }

    private fun postLogin(id: String, password: String) {
        viewModel.postLogin(
            id, password
        )
    }

    override fun initView() {
        initLoginButton()
    }


    override fun observeEvent() {

    }
}
