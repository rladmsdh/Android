package com.example.koin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val controller : SampleController by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller.print()
    }
}