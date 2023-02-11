package com.example.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recyclerview.ui.theme.RecyclerviewTheme
import com.example.recyclerview.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerviewTheme { MyRecyclerview() }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyRecyclerview(){
    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) { RecyclerViewContent() }
}

@Composable
fun RecyclerViewContent() {
    val puppies = remember { DataProvider.puppyList }
    LazyColumn(contentPadding = PaddingValues(16.dp,8.dp)){
        items(items =puppies, itemContent = {PuppyListItem(it)})
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyListItem(puppy: Puppy) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 12.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = { Log.d("onClick",puppy.name) }
        ) {
            Column(
               modifier = Modifier
                   .padding(8.dp)
            ) {
                Text(text = puppy.name, style = Typography.h6)
                Text(text = puppy.content, style = Typography.caption)
         }
    }
}

@Preview
@Composable
fun MyappPreview(){
    RecyclerviewTheme { MyRecyclerview() }
}