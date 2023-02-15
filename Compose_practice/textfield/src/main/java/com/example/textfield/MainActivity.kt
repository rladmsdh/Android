package com.example.textfield

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
        var text = remember { mutableStateOf("") }
        OutlinedTextField(
            value = text.value,
            onValueChange = {fieldValue -> text.value = fieldValue },
            label ={ Text("에딧텍스트") }
        )
        Button(onClick = { Log.d("text",text.value) }) {
            Text(text = "버튼")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TextFieldPreview(){
    TextFieldScreen()
}