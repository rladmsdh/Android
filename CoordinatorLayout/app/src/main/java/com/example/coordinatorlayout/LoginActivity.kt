package com.example.coordinatorlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.databinding.DataBindingUtil
import com.example.coordinatorlayout.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val content = SpannableString(binding.tvGoSignup.text.toString())
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        binding.tvGoSignup.text = content

        goSignup()
    }

    private fun goSignup() {
        binding.tvGoSignup.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}