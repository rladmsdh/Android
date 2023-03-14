package com.example.mvi_ex.mvi

import com.example.mvi_ex.mvi.model.Image

sealed class MviState{
    object Idle: MviState()
    object Loading: MviState()
    data class LoadedImage(val image: Image, val count: Int): MviState()
}
