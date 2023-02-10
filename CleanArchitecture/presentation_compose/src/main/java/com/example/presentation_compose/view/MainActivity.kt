package com.example.presentation_compose.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation_compose.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LoginView(viewModel) }
    }
}

@Composable
fun LoginView(viewModel:LoginViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.width(300.dp)) {
            val textId = remember { mutableStateOf("") }
            TextField(
                value = textId.value,
                onValueChange = { fieldValue -> textId.value = fieldValue },
                modifier = Modifier.fillMaxWidth()
            )
            val textPassword = remember { mutableStateOf("") }
            TextField(
                value = textPassword.value,
                onValueChange = { fieldValue -> textPassword.value = fieldValue },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = {
                    viewModel.postLogin(
                        id = textId.toString(),
                        password = textPassword.toString(),
                    )
                    Log.d("asd",textId.value)
                }, modifier = Modifier.fillMaxWidth()
            ) { Text(text = "버튼") }
        }
    }
}