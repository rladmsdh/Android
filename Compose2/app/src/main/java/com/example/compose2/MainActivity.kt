package com.example.compose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android","Jetpack Compose"))
        }
    }

    @Composable
    fun MessageCard(msg:Message) {
        Column(modifier = Modifier.padding(all = 4.dp)) {
            Row() {
                Text(text = msg.author,
                modifier = Modifier.width(60.dp))
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = msg.body,
                    modifier = Modifier.width(60.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
            )
        }
    }

    @Preview
    @Composable
    fun PreViewMessageCard(){
        MessageCard(msg = Message("Jetpack","Compose"))
    }
}