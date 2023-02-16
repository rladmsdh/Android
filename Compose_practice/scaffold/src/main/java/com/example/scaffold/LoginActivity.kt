package com.example.scaffold

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scaffold.ui.theme.ComposePracticeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this@LoginActivity,MainActivity::class.java)
        setContent {
            ComposePracticeTheme {
                ScaffoldExample2(onClicked = {startActivity(intent)})
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample2(onClicked : () -> Unit) {
    var text1 = remember { mutableStateOf("") }
    var text2 = remember { mutableStateOf("") }

    Scaffold ( topBar = {
        TopAppBar(
            title = { Text(text = "ScaffoldApp") }
        )
    }) {
        Scaffold(
            modifier = Modifier.padding(8.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = text1.value,
                    onValueChange ={ fieldValue -> text1.value = fieldValue},
                    label = { Text(text = "id")},
                    modifier = Modifier.size(320.dp,70.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = text2.value,
                    onValueChange ={ fieldValue -> text2.value = fieldValue},
                    label = { Text(text = "password")},
                    modifier = Modifier.size(320.dp,70.dp)
                )
                Spacer(modifier = Modifier.size(40.dp))
                Button(
                    onClick = onClicked,
                    modifier = Modifier.size(120.dp,60.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    ScaffoldExample2(onClicked = {})
}