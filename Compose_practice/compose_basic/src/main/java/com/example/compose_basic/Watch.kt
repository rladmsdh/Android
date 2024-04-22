package com.example.compose_basic

import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import kotlin.math.cos
import kotlin.math.sin

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Watch() {
    var hour by remember {
        mutableStateOf(LocalDateTime.now().hour)
    }
    var minute by remember {
        mutableStateOf(LocalDateTime.now().minute)
    }
    var second by remember {
        mutableStateOf(LocalDateTime.now().second)
    }
    var timerState by remember { mutableStateOf(false) }
    var timerCount by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            hour = LocalDateTime.now().hour
            minute = LocalDateTime.now().minute
            second = LocalDateTime.now().second
            if (timerState) {
                timerCount += 1
            }
            delay(1000)
        }
    }

    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Clock(
                modifier = Modifier
                    .size(260.dp)
                    .align(Alignment.Center),
                hour = hour,
                minute = minute,
                second = second,
            )
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .background(Color(0xFFFFB300))
            )
        }
        Timer(
            time = timerCount,
            onClick = {
                timerState = !timerState
                timerCount = 0
            },
            state = timerState
        )
    }
}


@Composable
fun Clock(
    modifier: Modifier = Modifier,
    clockStyle: ClockStyle = ClockStyle(),
    hour: Int,
    minute: Int,
    second: Int,
) {
    Canvas(modifier = modifier.padding(12.dp)) {
        drawArc(
            color = Color(0xFF000000),
            startAngle = 360f,
            sweepAngle = 360f,
            useCenter = false,
            size = Size(size.width, size.height),
            style = Stroke(width = 5f, cap = StrokeCap.Square)
        )
        val radius: Float = size.minDimension / 2.0f // 원의 반지름
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                center.x,
                center.y,
                radius,
                Paint().apply {
                    color = android.graphics.Color.WHITE
                    setShadowLayer(
                        clockStyle.shadowRadius.toPx(),
                        0f,
                        0f,
                        clockStyle.shadowColor.toArgb()
                    )
                }
            )
        }

        // 중심점
        drawCircle(
            radius = clockStyle.centerCircleSize.toPx(),
            color = clockStyle.centerCircleColor
        )

        // 시계 눈금
        val gradationCount = 60 // 시계눈금 갯수
        repeat(gradationCount) { index ->
            val angleInDegree = (index * 360 / gradationCount).toDouble()
            val angleInRadian = Math.toRadians(angleInDegree)

            val isHourGradation = index % 5 == 0
            val length = if (isHourGradation) {
                clockStyle.hourGradationLength.toPx()
            } else {
                clockStyle.minuteGradationLength.toPx()
            }

            val start = Offset(
                x = (center.x + (radius - length) * Math.cos(angleInRadian)).toFloat(),
                y = (center.y + (radius - length) * Math.sin(angleInRadian)).toFloat()
            )
            val end = Offset(
                x = (center.x + radius * Math.cos(angleInRadian)).toFloat(),
                y = (center.y + radius * Math.sin(angleInRadian)).toFloat()
            )
            val gradationColor: Color = if (isHourGradation) {
                clockStyle.hourGradationColor
            } else {
                clockStyle.minuteGradationColor
            }

            val gradationWidth: Dp = if (isHourGradation) {
                clockStyle.hourGradationWidth
            } else {
                clockStyle.minuteGradationWidth
            }

            //시,분 눈금 그리기
            drawLine(
                color = gradationColor,
                start = start,
                end = end,
                strokeWidth = gradationWidth.toPx()
            )

            // 1~12시 텍스트 그리기
            drawContext.canvas.nativeCanvas.apply {
                if (index % 5 == 0) {
                    var hourText = (index / 5 + 3) % 12
                    if (hourText == 0) {
                        hourText = 12
                    }
                    val textSize = clockStyle.textSize.toPx()
                    val textRadius = radius - length - textSize
                    val x = textRadius * cos(angleInRadian) + center.x
                    val y = textRadius * sin(angleInRadian) + center.y + textSize / 2f
                    drawText(
                        "$hourText",
                        x.toFloat(),
                        y.toFloat(),
                        Paint().apply {
                            this.color = clockStyle.textColor.toArgb()
                            this.textSize = textSize
                            this.textAlign = Paint.Align.CENTER
                        }
                    )
                }
            }
        }

        // 시침 그리기(Hour hand)
        val hourAngleIncrement = 360.0 / 12.0
        val hourHandInDegree = (
                -90 // 12시부터 시작하도록 90도 꺾음
                        + hour * hourAngleIncrement
                        + hourAngleIncrement * minute.toDouble() / TimeUnit.HOURS.toMinutes(1)
                        + hourAngleIncrement * second.toDouble() / TimeUnit.HOURS.toSeconds(1)
                )
        val hourHandInRadian = Math.toRadians(hourHandInDegree)
        val hourHandStart = Offset(
            x = center.x,
            y = center.y
        )
        val hourHandEnd = Offset(
            x = (center.x + clockStyle.hourHandLength.toPx() * Math.cos(hourHandInRadian)).toFloat(),
            y = (center.y + clockStyle.hourHandLength.toPx() * Math.sin(hourHandInRadian)).toFloat()
        )
        drawLine(
            color = clockStyle.hourHandColor,
            start = hourHandStart,
            end = hourHandEnd,
            strokeWidth = clockStyle.hourHandWidth.toPx(),
            cap = StrokeCap.Round
        )

        // 분침 그리기(Minute hand)
        val minuteAngleIncrement = 360.0 / 60.0
        val minuteHandInDegree = (
                -90 // 90도 꺾음
                        + minuteAngleIncrement * minute.toDouble()
                        + minuteAngleIncrement * second.toDouble() / TimeUnit.MINUTES.toSeconds(1)
                )

        val minuteHandInRadian = Math.toRadians(minuteHandInDegree)

        val minuteLineStart = Offset(
            x = center.x,
            y = center.y
        )
        val minuteLineEnd = Offset(
            x = (center.x + clockStyle.minuteHandLength.toPx() * cos(minuteHandInRadian)).toFloat(),
            y = (center.y + clockStyle.minuteHandLength.toPx() * sin(minuteHandInRadian)).toFloat()
        )

        drawLine(
            color = clockStyle.minuteHandColor,
            start = minuteLineStart,
            end = minuteLineEnd,
            strokeWidth = clockStyle.minuteHandWidth.toPx(),
            cap = StrokeCap.Round
        )

        // 초침 그리기 (Second hand)
        val secondAngleIncrement = 360.0 / 60.0
        val secondInDegree = -90 + secondAngleIncrement * second.toDouble()
        val secondInRadian = Math.toRadians(secondInDegree)
        val secondLineStart = Offset(
            x = center.x,
            y = center.y
        )
        val secondLineEnd = Offset(
            x = (center.x + clockStyle.secondHandLength.toPx() * cos(secondInRadian)).toFloat(),
            y = (center.y + clockStyle.secondHandLength.toPx() * sin(secondInRadian)).toFloat()
        )

        drawLine(
            color = clockStyle.secondHandColor,
            start = secondLineStart,
            end = secondLineEnd,
            strokeWidth = clockStyle.secondHandWidth.toPx(),
            cap = StrokeCap.Round
        )
    }
}

/**
 * this is fun that timer operator
 *
 * @param time Time that has passed so far
 * @param onClick Timers start and end operations
 * @param state Timer state
 */
@Composable
fun Timer(
    time: Int,
    onClick: () -> Unit,
    state: Boolean,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .size(100.dp, 40.dp)
                .align(CenterHorizontally)
        ) {
            Text(text = if (state) "끝" else "시작")
        }
        Text(
            text = time.toString(),
            modifier = Modifier
                .size(100.dp, 40.dp)
                .align(CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}