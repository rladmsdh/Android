package com.example.scaffold

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scaffold.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this@MainActivity,LoginActivity::class.java)
        setContent {
            ComposePracticeTheme {
                ScaffoldExample(
                    onClicked = {
                        startActivity(intent)
                })
            }
        }
    }
}

@Composable
fun CheckboxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content : @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState() }
        )
        content()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample(onClicked : () -> Unit) {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Scaffold( topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClicked) {
                        Image(imageVector = Icons.Filled.ArrowBack, contentDescription = "뒤로 가기")
                    }
                },
                title = { Text(text = "ScaffoldApp") }
            )
        }) {
        Scaffold(modifier = Modifier.padding(8.dp)) {
            Column {
                CheckboxWithContent(checked = checked1, toggleState = { checked1 = !checked1 }) {
                    Text(text = "컴포즈를 좋아한다.")
                 }
                CheckboxWithContent(checked = checked2, toggleState = { checked2 = !checked2 }) {
                    Text(text = "컴포즈를 좋아한다.2")
                 }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        ScaffoldExample(onClicked = {})
    }
}