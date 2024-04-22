package com.example.compose_basic

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.compose_basic.ui.theme.Theme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
//                Loading()

//                ButtonExample (onButtonClicked = {
//                    Toast.makeText(this@MainActivity,"clicked",Toast.LENGTH_SHORT).show()
//                })

//                ModifierExample (onButtonClicked = {
//                    Toast.makeText(this@MainActivity,"clicked",Toast.LENGTH_SHORT).show()
//                })

//                SurfaceExample(name = "Android")

//                BoxExample()

//                RowExample()

//                ColumnExample()

//                Outer()

//                ImageExample()

//                CoilExample()

//                Surface(
//                    modifier = Modifier.size(100.dp),
//                    color = MaterialTheme.colors.background
//                ) {
//                    //CardExample(cardData = cardData)
//                    Logo()
//                }
//                Watch()

            }
        }
    }

    //cardexample
    companion object {
        val cardData = CardData(
            imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg",
            imageDescription = "엔텔로프 캐년",
            author = "euno",
            description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
        )
    }
}

@Composable
fun TextExample(name: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00ACC1)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .background(Color.White)
                .padding(end = 10.dp)
                .clip(RoundedCornerShape(8.dp))
                .size(250.dp),
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
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
        )
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
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

//
@Composable
fun ModifierExample(onButtonClicked: () -> Unit) {
    Button(
        onClick = onButtonClicked,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black,
        ),
        modifier = Modifier
            .size(200.dp, 100.dp)
            .padding(30.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
        )
        Spacer(
            modifier = Modifier
                .size(ButtonDefaults.IconSpacing)
        )
        Text(
            text = "Search",
            modifier = Modifier
                .offset(x = 5.dp)
        )
    }
}

//Material 디자인의 기본적인 패턴
@Composable
fun SurfaceExample(name: String) {
    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black,
        ),
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp,
        shape = CircleShape,
        color = MaterialTheme.colors.surface
    ) {
        Text(
            text = "Hello $name",
            modifier = Modifier.padding(8.dp),
        )
    }
}

//가로+세로
@Composable
fun BoxExample() {
    Box(modifier = Modifier.size(100.dp)) {
        Text(text = "Jetpack", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Compose", modifier = Modifier.align(Alignment.CenterEnd))
    }
}

//가로
@Composable
fun RowExample() {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f)
                .background(Color.Red)
        )
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "추가",
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        )
        Text(
            text = "세 번째",
            modifier = Modifier
                .weight(3f)
                .background(Color.Blue)
        )
    }
}

//세로
@Composable
fun ColumnExample() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(100.dp),
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "두 번째")
        Text(
            text = "세 번째",
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

//BoxWithConstraintsExample
@Composable
fun Outer() {
    Column(modifier = Modifier.width(150.dp)) {
        Inner(
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
        )
    }
}

@Composable
private fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints((modifier)) {
        if (maxHeight >= 150.dp) {
            Text(
                text = "길다",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
        Text("maxW:$maxWidth maxH:$maxHeight minW: $minWidth minH:$minHeight")
    }
}

@Composable
fun ImageExample() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "안드로이드"
        )
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )
    }
}

//Preview 안됨
@Composable
fun CoilExample() {
    Column {
        //rememberImagePainter 사용 가능
        AsyncImage(
            model = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg",
            contentDescription = "엔텔로프 캐년"
        )
        AsyncImage(
            model = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg",
            contentDescription = "엔텔로프 캐년"
        )
    }
}

@Composable
fun CardExample(cardData: CardData) {
    val placeholderColor = Color(0x33000000)
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(placeholderColor),
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }
        }
    }
}

@Composable
fun Logo() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawCircle(
            color = Color(0xFF0091F2),
            radius = 30f,
            center = Offset(size.width * .25f, size.height * .05f),
        )

        rotate(degrees = 50F) {
            drawRoundRect(
                color = Color(0XFF00C3C3),
                size = Size(50f, 50f),
                topLeft = Offset(x = size.width * .25f, y = size.height * .05f),
                cornerRadius = CornerRadius(2f, 2f)
            )
        }

        drawPath(
            path = Path().apply {
                moveTo(size.width * .35f, size.height * .25f)
                lineTo(size.width * .28f, size.height * .58f)
                lineTo(size.width * .60f, size.height * .50f)
                close()
            },
            color = Color(0xFFE97BBC),
        )

        drawArc(
            color = Color(0XFF00C379),
            startAngle = 360f,
            sweepAngle = 180f,
            useCenter = false,
            size = Size(size.width - 10f, size.height - 10f),
            style = Stroke(width = 45f, cap = StrokeCap.Square)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    //TextExample(name = "Android")

    //ButtonExample(onButtonClicked = {})

    //ModifierExample(onButtonClicked = {})

    //SurfaceExample(name = "Android")

    //BoxExample()

    //RowExample()

    //ColumnExample()

    //Outer()

    //ImageExample()

    //CardExample(MainActivity.cardData)

    //Logo()

    Clock(
        modifier = Modifier.size(300.dp),
        hour = 2,
        minute = 20,
        second = 30,
    )
}