package com.example.compose_basic

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_basic.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                //TextExample(name = "Android")

                ButtonExample (onButtonClicked = {
                    Toast.makeText(this@MainActivity,"clicked",Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun TextExample(name: String) {
    Text(
        modifier = Modifier.size(300.dp),
        color = Color.Red,
        text = "Hello $name\nHello $name",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        letterSpacing = 2.sp,
    )
}

@Composable
fun ButtonExample(onButtonClicked : () -> Unit) {
    Button(
        onClick = onButtonClicked,
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(20.dp),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    //TextExample(name = "Android")

    ButtonExample(onButtonClicked = {})
}