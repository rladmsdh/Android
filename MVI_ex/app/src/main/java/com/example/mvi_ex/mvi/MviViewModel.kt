package com.example.mvi_ex.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mvi_ex.mvi.repository.ImageRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MviViewModel(private val imageRepository: ImageRepository): ViewModel() {

    val channel = Channel<MviIntent>()

    private val _state = MutableStateFlow<MviState>(MviState.Idle)
    val state: StateFlow<MviState> get() = _state

    private var count = 0

    init {
        handleIntent()
    }
    private fun handleIntent(){
        viewModelScope.launch {
            channel.consumeAsFlow().collectLatest {
                when(it){
                    MviIntent.LoadImage ->{
                        loadImage()
                    }
                }
            }
        }
    }

    private fun loadImage() {
        viewModelScope.launch {
            _state.value = MviState.Loading
            val image = imageRepository.getRandomImage()
            count++
            _state.value = MviState.LoadedImage(image,count)
        }
    }

    class MviViewModelFactory(private val imageRepository: ImageRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MviViewModel(imageRepository) as T
        }
    }
}