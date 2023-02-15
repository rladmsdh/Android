package com.example.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkbox.ui.theme.CheckBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxTheme {
                CheckBoxExample()
            }
        }
    }
}

@Composable
fun CheckBoxExample() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        //remember {mutableStateOf(false)}
//        var checked = remember { mutableStateOf(false) }
//        Checkbox (
//            checked = checked.value,
//            onCheckedChange = {
//                checked.value = !checked.value
//            }
//        )

        //delegated properties
//        var checked by remember { mutableStateOf(false) }
//        Checkbox (
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )

        //destruction 으로 상태 받기
        val (getter,setter) = remember { mutableStateOf(false) }
        Checkbox (
            checked = getter,
            onCheckedChange = setter
        )
        Text(text = "개발자 입니까?")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CheckBoxTheme {
        CheckBoxExample()
    }
}

