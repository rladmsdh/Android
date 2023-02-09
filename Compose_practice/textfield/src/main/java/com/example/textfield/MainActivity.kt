package com.example.textfield

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldScreen()
        }
    }
}

@Composable
fun TextFieldScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        var text = remember {
            mutableStateOf("")
        }
        TextField(value = text.value,
            onValueChange = {fieldValue -> text.value = fieldValue },
        )
        Button(onClick = { Log.d("text",text.value) }) {
            Text(text = "버튼")
        }
    }
}

@Composable
@Preview
fun TextFieldPreview(){
    TextFieldScreen()
}