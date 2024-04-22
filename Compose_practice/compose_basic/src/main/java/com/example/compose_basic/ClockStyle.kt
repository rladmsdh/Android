package com.example.compose_basic

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class ClockStyle(
    val hourHandWidth: Dp = 4.dp, // 시침 두께
    val minuteHandWidth: Dp = 4.dp, // 분침 두께
    val secondHandWidth: Dp = 2.dp, // 초침 두께
    val hourHandLength: Dp = 70.dp, // 시침 길이
    val minuteHandLength: Dp = 90.dp, // 분침 길이
    val secondHandLength: Dp = 110.dp, // 초침 길이
    val hourHandColor: Color = Color(0xFFFFB300), // 시침 색상
    val minuteHandColor: Color = Color(0xFFFFB300), // 분침 색상
    val secondHandColor: Color = Color(0xFFFFB300), // 초침 색상
    val textColor: Color = Color.Black, // 1~12 텍스트 색상
    val textSize: Dp = 20.dp, // 1~12 텍스트 크기
    val hourGradationWidth: Dp = 2.dp, // 시간 눈금 두께
    val minuteGradationWidth: Dp = 1.dp, // 분 눈금 두께
    val hourGradationColor: Color = Color.Black, // 시간 눈금 색상
    val minuteGradationColor: Color = Color.Black, // 분 눈금 색상
    val hourGradationLength: Dp = 20.dp, // 시간 눈금 길이
    val minuteGradationLength: Dp = 10.dp, // 분 눈금 길이
    val shadowRadius:Dp = 3.dp,  // 배경 그림자 크기
    val shadowColor:Color = Color.Black.copy(alpha = 0.5f), // 배경 그림자 색상
    val centerCircleSize:Dp = 3.dp, // 중심점 크기
    val centerCircleColor:Color = Color(0xFFFFB300) // 중심점 색상
)
