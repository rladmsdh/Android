package com.example.textfield

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
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

    val text1 = remember { mutableStateOf("") }
    val text2 = remember { mutableStateOf("") }

    Column {
        TextFieldWithSlot(
            text = text1,
            label = { Text(text = "에딧텍스트1") },
            clicked = { Log.d("text1",text1.value) }
        )
        TextFieldWithSlot(
            text = text2,
            label = { Text(text = "에딧텍스트2") },
            clicked = { Log.d("text2",text2.value) }
        )
    }
}
@Composable
fun TextFieldWithSlot(
    text: MutableState<String>,
    label: @Composable () -> Unit,
    clicked: () -> Unit,
) {
    Column {
        OutlinedTextField(
            value = text.value,
            onValueChange = {fieldValue -> text.value = fieldValue },
            label = label
        )
        Button(onClick = clicked) {
            Text(text = "버튼")
        }
    }
}


@Composable
@Preview(showBackground = true)
fun TextFieldPreview(){
    TextFieldScreen()
}