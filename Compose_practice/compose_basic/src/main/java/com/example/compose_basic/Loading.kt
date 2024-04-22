package com.example.compose_basic

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Loading() {
    val colors = remember {
        mutableStateOf(
            listOf(
                Color.Gray,
                Color.Gray,
                Color.DarkGray,
                Color.LightGray,
                Color.LightGray,
                Color.LightGray,
                Color.LightGray,
                Color.LightGray,
            )
        )
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(100)
            colors.value = colors.value.rotate(1)
        }
    }

    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(12.dp)
    ) {
        val radius: Float = size.minDimension / 2.0f

        val gradationCount = 8
        repeat(gradationCount) { index ->
            val angleInDegree = (index * 360 / gradationCount).toDouble()
            val angleInRadian = Math.toRadians(angleInDegree)

            val length = 20.dp.toPx()
            drawContext.canvas.nativeCanvas.apply {
                val boxSize = 20.dp.toPx()
                val boxRadius = radius - length - boxSize
                val x = boxRadius * cos(angleInRadian) + center.x
                val y = boxRadius * sin(angleInRadian) + center.y + boxSize / 2f
                drawCircle(
                    radius = 20.dp.toPx(),
                    color = colors.value[index],
                    center = Offset(x.toFloat(), y.toFloat())
                )
            }
        }
    }
}

fun <T> List<T>.rotate(rotationDistance: Int): List<T> {
    if (this.isEmpty()) return this
    val realRotation = rotationDistance % this.size
    return this.takeLast(realRotation) + this.dropLast(realRotation)
}