package com.example.lifecycle

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//반투명 액티비티
class SubActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }
}