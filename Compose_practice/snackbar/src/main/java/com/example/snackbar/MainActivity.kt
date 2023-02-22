package com.example.snackbar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.snackbar.ui.theme.ComposePracticeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                SnackBarEx()
            }
        }
    }
}

@Composable
fun SnackBarEx() {
    val snackBarState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    val buttonTitle: (SnackbarData?) -> String = { data ->
        if (data != null){
            "숨기기"
        } else {
            "보이기"
        }
    }

    val buttonColors: (SnackbarData?) -> Color = { data ->
        if (data != null){
            Color.Black
        } else{
            Color.DarkGray
        }
    }
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = buttonColors(snackBarState.currentSnackbarData),
                contentColor = Color.White
            ),
            onClick = {
                if(snackBarState.currentSnackbarData != null){
                    snackBarState.currentSnackbarData?.dismiss()
                    return@Button
                }
                coroutineScope.launch {
                    val result = snackBarState.showSnackbar(
                        "보이기",
                        "닫기",
                        SnackbarDuration.Long
                    ).let {
                        when(it){
                            SnackbarResult.Dismissed -> Log.d("Tag","닫아짐")
                            SnackbarResult.ActionPerformed -> Log.d("Tag","확인 클릭")
                        }
                    }
                }
            }) {
            Text(buttonTitle(snackBarState.currentSnackbarData))
        }
        SnackbarHost(hostState = snackBarState, modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme { SnackBarEx() }
}